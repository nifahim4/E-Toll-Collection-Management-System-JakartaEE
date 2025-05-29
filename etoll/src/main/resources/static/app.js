document.addEventListener('DOMContentLoaded', function() {
    // For the main toll form (index.jsp)
    if (document.getElementById('tollForm')) {
        fetchRecords();

        document.getElementById('tollForm').onsubmit = async function(e) {
            e.preventDefault();
            const form = e.target;
            const data = {
                driverName: form.driverName.value,
                driverLisence: form.driverLisence.value,
                vehicleNumber: form.vehicleNumber.value,
                vehicleModel: form.vehicleModel.value,
                vehicleType: form.vehicleType.value
            };
            try {
                const resp = await fetch('/api/vehicles', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(data)
                });
                const msg = await resp.text();
                document.getElementById('tollMessage').innerText = msg;
                fetchRecords();
                form.reset();
            } catch (err) {
                document.getElementById('tollMessage').innerText = 'Error submitting toll record.';
            }
        };
    }

    // For the search form (search.jsp)
    if (document.getElementById('searchForm')) {
        document.getElementById('searchForm').onsubmit = async function(e) {
            e.preventDefault();
            const form = e.target;
            const from = form.fromDate.value; // 'YYYY-MM-DD'
            const to = form.toDate.value;     // 'YYYY-MM-DD'
            try {
                const resp = await fetch(`/api/vehicles/search?from=${from}&to=${to}`);
                if (!resp.ok) {
                    alert("Search failed or invalid date format.");
                    return;
                }
                const data = await resp.json();
                fillSearchResults(data);
            } catch (err) {
                alert("Failed to fetch search results.");
            }
        };
    }
});

// Fetch and display all toll records (for index.jsp)
function fetchRecords() {
    fetch('/api/vehicles')
        .then(resp => resp.json())
        .then(data => {
            const tbody = document.querySelector('#recordsTable tbody');
            tbody.innerHTML = "";
            data.forEach(row => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                    <td>${row.id}</td>
                    <td>${row.driverName}</td>
                    <td>${row.driverLisence}</td>
                    <td>${row.vehicleNumber}</td>
                    <td>${row.vehicleModel}</td>
                    <td>${row.vehicleType}</td>
                    <td>${row.date ? row.date.replace('T', ' ').substring(0, 16) : ''}</td>
                    <td>
                        <button onclick="deleteRecord(${row.id})">Delete</button>
                    </td>
                `;
                tbody.appendChild(tr);
            });
        })
        .catch(() => {
            const tbody = document.querySelector('#recordsTable tbody');
            tbody.innerHTML = "<tr><td colspan='8'>Failed to load records.</td></tr>";
        });
}

// Delete a record by ID (for index.jsp)
function deleteRecord(id) {
    if (confirm('Delete this record?')) {
        fetch(`/api/vehicles/${id}`, {method: 'DELETE'})
            .then(() => fetchRecords())
            .catch(() => alert('Failed to delete the record.'));
    }
}

// Clear the main toll form (for index.jsp)
function clearForm() {
    document.getElementById('tollForm').reset();
    document.getElementById('tollMessage').innerText = '';
}

// Fill the search results table (for search.jsp)
function fillSearchResults(data) {
    const tbody = document.querySelector('#searchResults tbody');
    tbody.innerHTML = "";
    if (!data || data.length === 0) {
        tbody.innerHTML = "<tr><td colspan='7'>No records found for this date range.</td></tr>";
        return;
    }
    data.forEach(row => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${row.id}</td>
            <td>${row.driverName}</td>
            <td>${row.driverLisence}</td>
            <td>${row.vehicleNumber}</td>
            <td>${row.vehicleModel}</td>
            <td>${row.vehicleType}</td>
            <td>${row.date ? row.date.replace('T', ' ').substring(0, 16) : ''}</td>
        `;
        tbody.appendChild(tr);
    });
}