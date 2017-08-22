var prefix = '/todo';
//меняет флаг первой записи в первом списке на true.
var Mark = function() {
    var JSONObject= {
        'id': 1,//ид записи которою меняем
        'checkmark': true
    };
    $.ajax({
        type: 'PUT',
        url:  prefix + '/' + 1, //ид списка в котором запись
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'text',
        async: true,
        success: function(result) {
            alert(result);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText + ' ' + textStatus + ' ' + errorThrown);
        }
    });
}