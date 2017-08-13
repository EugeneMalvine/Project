
var prefix = '/functional';
var collection = null;
    var tbl = null;
    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url: prefix,
            dataType: 'json',
            async: true,
            success: function(result) {
                collection = result;
                console.log(collection);

                tbl = '<tr>';
                for(var i = 0; i < collection.length; i++){
                    tbl += '<td> ' + collection[i].id + ' </td>';
                    tbl += '<td> ' + collection[i].firstName + ' </td>';
                    tbl += '<td> ' + collection[i].lastName + ' </td>';
                    tbl += '</tr><tr>';
                }
                tbl += '</tr>';
                document.getElementById("table").innerHTML = tbl;

                //document.write( collection );
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText + ' ' + textStatus + errorThrown);
            }
        });
    }


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

            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText + ' ' + textStatus + ' ' + errorThrown);
            }
        });
    }
     var RestDelete = function() {

        var id = document.getElementById("id").value;
        $.ajax({
            type: 'DELETE',
            url:  prefix ,
            dataType: 'text',
            data: id,
            async: true,
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }