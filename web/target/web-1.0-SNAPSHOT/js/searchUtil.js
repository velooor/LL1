
function showAll() {
    $(document).ready(function () {
        $.ajax({
            url: '/main',
            data: {
                command: "mainSearch"
            },
            contentType: "application/json",
            success: function (data) {
                $('#title').html("All");

                // var array = $.parseJSON(data);
                perfectShow(data);
            }
        });
    });
    showMain();
}

function showAvailable() {
    showMain();
    $(document).ready(function () {
        $.ajax({
            url: '/main',
            data: {
                command: "mainSearch"
            },
            contentType: "application/json",
            success: function (data) {
                $('#title').html("Available");

                //var array = $.parseJSON(data);
                perfectShow(data);
            }
        });
    });
}

function add() {
    showMain();
    $(document).ready(function () {
        $.ajax({
            url: '/main',
            data: {
                command: "mainSearch"
            },
            contentType: "application/json",
            success: function (data) {
                alert("New apartment is registered")
                $('#title').html("Available");
                perfectShow(data);
            }
        });
    });
}

function perfectShow(array) {
    $('#apartments').empty();
    for(var i = 0; i < array.length; i++){
        $('#apartments').append(
            '<div class="allRow">' +
            ' <div class="id">' + array[i].apId + '</div>' +
            ' <div class="date">' + array[i].startDate + '</div>' +
            ' <div class="date">' + array[i].endDate + '</div>' +
            '</div>');
    }
}

function showMain() {
    var main = document.getElementById("main");
    main.style.visibility = "visible";
}