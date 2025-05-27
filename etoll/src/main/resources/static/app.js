document.addEventListener('DOMContentLoaded', function() {
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
        const resp = await fetch('/api/vehicles', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });
        const msg = await resp.text();
        document.getElementById('tollMessage').innerText = msg;
        fetchRecords();
        form.reset();
    };

    document.getElementById('searchForm').onsubmit = async function(e) {
        e.preventDefault();
        const from = e.target.fromDate.value + 'T00:00:00';
        const to = e.target.toDate.value + 'T23:59:59';
        const resp = await fetch(`/api/vehicles/search?from=${from}&to=${to}`);
        const data = await resp.json();
        fillSearchResults(data);
    };
});

function fetchRecords() {
    fetch('/api/vehicles').then(resp => resp.json()).then(data => {
        const tbody = document.querySelector('#recordsTable tbody');
        tbody.innerHTML = '';
        data.forEach(dv => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${dv.id}</td>
                <td>${dv.driverName}</td>
                <td>${dv.driverLisence}</td>
                <td>${dv.vehicleNumber}</td>
                <td>${dv.vehicleModel}</td>
                <td>${dv.vehicleType}</td>
                <td>${dv.date ? dv.date.replace('T', ' ').substring(0, 16): ''}</td>
                <td>
                    <button onclick="deleteRecord(${dv.id})">Delete</button>
                </td>
            `;
            tbody.appendChild(tr);
        });
    });
}

function deleteRecord(id) {
    if (confirm('Delete this record?')) {
        fetch(`/api/vehicles/${id}`, {method: 'DELETE'}).then(() => {
            fetchRecords();
        });
    }
}

function fillSearchResults(data) {
    const tbody = document.querySelector('#searchResults tbody');
    tbody.innerHTML = '';
    data.forEach(dv => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${dv.id}</td>
            <td>${dv.driverName}</td>
            <td>${dv.driverLisence}</td>
            <td>${dv.vehicleNumber}</td>
            <td>${dv.vehicleModel}</td>
            <td>${dv.vehicleType}</td>
            <td>${dv.date ? dv.date.replace('T', ' ').substring(0, 16): ''}</td>
        `;
        tbody.appendChild(tr);
    });
}

function clearForm() {
    document.getElementById('tollForm').reset();
    document.getElementById('tollMessage').innerText = '';
}