<%--
  Created by IntelliJ IDEA.
  User: Nakibul Fahim
  Date: 27-May-25
  Time: 3:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-Toll Collection Management System</title>
    <link rel="stylesheet" href="/style.css">
    <script src="/app.js"></script>
</head>
<body>
<div class="container">
    <img src="/toll_logo.png" alt="Toll Logo" class="toll-logo">
    <button type="button" onclick="window.location.href='search'" style="float: right">Search By Date</button>
    <br>
    <h1>E-Toll Collection Management System</h1>
    <form id="tollForm">
        <table id="tollTable">
            <tr>
                <th><label>Driver's Name:</label></th>
                <th><input type="text" name="driverName" required placeholder="Example: Nakibul,Shesher"  /></th>
            </tr>
            <tr>
                <th><label>Driver's License:</label></th>
                <th><input type="text" name="driverLisence" required placeholder="Example: 2023100010076" /></th>
            </tr>
            <tr>
                <th><label>Vehicle Number:</label></th>
                <th><input type="text" name="vehicleNumber" required placeholder="151319" /></th>
            </tr>
            <tr>
                <th><label>Vehicle Model:</label></th>
                <th><input type="text" name="vehicleModel" required placeholder="GT200" /></th>
            </tr>
            <tr>
                <th><label>Vehicle Type:</label></th>
                <th><select name="vehicleType" required>
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
                </select></th>
            <br>
            </tr>

        </table>
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

        </tbody>
    </table>
<%--    <h3>Search by Date</h3>
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
        </tbody>
    </table>--%>
</div>
</body>
</html>