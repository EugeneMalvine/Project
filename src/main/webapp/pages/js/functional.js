
var prefix = '/functional';
var collection = null;


    //функция обновляет таблицу в соответствии с коллекцией
    var UpdateTable = function(collection){
        var tbl = '<tr>';
        for(var i = 0; i < collection.length; i++){
            tbl += '<td> ' + collection[i].id + ' </td>';
            tbl += '<td> ' + collection[i].firstName + ' </td>';
            tbl += '<td> ' + collection[i].lastName + ' </td>'
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                tbl += '<td>' +  '<button type="reset" class="btn btn-danger" onclick=RestDelete("' +
                    collection[i].id + '")><span class="glyphicon glyphicon-remove"></span>Delete</button>' + '</td>';
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                tbl += '<td></td>';
            </sec:authorize>

            tbl += '</tr><tr>';
        }
        tbl += '</tr>';
        document.getElementById("table").innerHTML = tbl;
    }

    //запрос на получение на сервер. Возвращает коллекцию элементов
    // в глобальную переменную collection
    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url: prefix,
            dataType: 'json',
            async: true,
            success: function(result) {
                collection = result;
                UpdateTable(collection);

            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText + ' ' + textStatus + errorThrown);
            }
        });
    }

    //обработчик кнопки добавить.
    var RestAdd = function() {
        var JSONObject= {
            'firstName': document.getElementById("exampleInputName").value,
            'lastName': document.getElementById("exampleInputLastName").value
        };

        $.ajax({
            type: 'POST',
            url:  prefix,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'text',
            async: true,
            success: function(result) {
                RestGet();
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText + ' ' + textStatus + ' ' + errorThrown);
            }
        });
    }


    //запрос на удаление id из бд
    var RestDelete = function(id) {
    $.ajax({
        type: 'DELETE',
        url:  prefix ,
        dataType: 'text',
        data: id,
        async: true,
        success : function(result){
            RestGet();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}




