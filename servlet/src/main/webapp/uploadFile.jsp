<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File</title>
</head>

<body>
	<form action="UploadDownloadFileServlet" enctype="multipart/form-data" method="post">
		Please select a file to upload: <input type="file" name="fileName">
		<br>
		<input type="submit" value="Upload">
	</form>
</body>

</html>