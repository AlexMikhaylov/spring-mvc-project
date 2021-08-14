<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Events</title>
</head>
<body>
<section>
    <h1>Event 1</h1>
    <div>
        <h3>Name</h3>
        ${message.getName()}
    </div>

    <div>
        <h3>Date</h3>
        ${message.getLocalDate().toString()}
    </div>

    <div>
        <h3>Participants</h3>
        ${message.getParticipants().size()}
    </div>
</section>

</body>
</html>
