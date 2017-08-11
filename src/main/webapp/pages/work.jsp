<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devcolibri.com exam REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var prefix = '/work';
    var collection = null;
    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url:  prefix,
            dataType: 'json',
            async: true,
            success: function(result) {
                collection = result;
                alert( collection );
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    var RestAdd = function() {
        var JSONObject= {
            'firstName': 'Hello',
            'lastName': 'World'
        };

        $.ajax({
            type: 'POST',
            url:  prefix,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert(result.toString());
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }


    var RestDelete = function() {

        var id = '0';
        $.ajax({
            type: 'DELETE',
            url:  prefix ,
            dataType: 'text',
            data: id,
            async: true,
            success: function(result) {
                alert('Время: ' + result.time
                    + ', сообщение: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
</script>

<body>

<h3>Это простой пример использования REST c помощью Ajax</h3>

<button type="button" onclick="RestGet()">Метод GET</button>
<button type="button" onclick="RestAdd()">Метод POST</button>
<button type="button" onclick="RestDelete()">Метод DELETE</button>


</body>
</html>