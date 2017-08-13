<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Devcolibri.com exam REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var prefix = '/functional';
    var collection = null;
    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url: prefix,
            dataType: 'json',
            async: true,
            success: function(result) {
                console.log(result);
                collection = result;
                console.log(collection);
                for(i=0;i < result.length;i++)
                {
                  document.writeln(collection[i].firstName + ' ' + collection[i].lastName);
                }
                //document.write( collection );
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
                alert('абаЕаМб: ' + result.time
                    + ', баОаОаБбаЕаНаИаЕ: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
</script>

<body>

<h3>а­баО аПбаОббаОаЙ аПбаИаМаЕб аИбаПаОаЛбаЗаОаВаАаНаИб REST c аПаОаМаОббб Ajax</h3>

<button type="button" onclick="RestGet()">ааЕбаОаД GET</button>
<button type="button" onclick="RestAdd()">ааЕбаОаД POST</button>
<button type="button" onclick="RestDelete()">ааЕбаОаД DELETE</button>


</body>
</html>