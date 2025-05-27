<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-Toll Collection Management System</title>
    <link rel="stylesheet" href="/style.css">
    <script src="/app.js"></script>
</head>
<body>
<div class="container">
    <h1>E-Toll Collection Management System</h1>
    <form id="tollForm">
        <label>Driver's Name: <input type="text" name="driverName" required /></label><br>
        <label>Driver's License: <input type="text" name="driverLisence" required /></label><br>
        <label>Vehicle Number: <input type="text" name="vehicleNumber" required /></label><br>
        <label>Vehicle Model: <input type="text" name="vehicleModel" required /></label><br>
        <label>Vehicle Type:
            <select name="vehicleType" required>
                <option value="">Select</option>
                <option>Motorcycle</option>
                <option>Car/JEEP</option>
                <option>Pickup</option>
                <option>Microbus</option>
                <option>Truck(up to 5 tonnes)</option>
                <option>Truck(5-10 tonnes)</option>
                <option>Truck(10-15 tonnes)</option>
                <option>MINI-Bus</option>
                <option>MEDIUM-Bus</option>
                <option>LARGE-Bus</option>
                <option>Trailer</option>
            </select>
        </label><br>
        <button type="submit">Collect Toll</button>
        <button type="button" onclick="clearForm()">Clear</button>
    </form>
    <div id="tollMessage"></div>
    <h2>All Toll Records</h2>
    <table id="recordsTable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Driver Name</th>
            <th>License</th>
            <th>Vehicle Number</th>
            <th>Model</th>
            <th>Type</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <!-- Filled by JS -->
        </tbody>
    </table>
    <h3>Search by Date</h3>
    <form id="searchForm">
        <label>From: <input type="date" name="fromDate" required /></label>
        <label>To: <input type="date" name="toDate" required /></label>
        <button type="submit">Search</button>
    </form>
    <table id="searchResults">
        <thead>
        <tr>
            <th>ID</th>
            <th>Driver Name</th>
            <th>License</th>
            <th>Vehicle Number</th>
            <th>Model</th>
            <th>Type</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <!-- Filled by JS -->
        </tbody>
    </table>
</div>
</body>
</html>