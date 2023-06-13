$(document).ready(function() {
    $('form').submit(function(e) {
        e.preventDefault();

        // check valid gpa
        var gpa = $('#gpa').val();
        if (!isValidGPA(gpa)) {
            $('#gpa')[0].setCustomValidity("Invalid GPA. Please enter a valid GPA between 0.00 and 4.33.");
        } else {
            $('#gpa')[0].setCustomValidity('');
            
            // send to endpoint /students/add
            $.ajax({
                type: 'POST',
                url: '/students/add',
                data: $(this).serialize(), 
                success: function() {
                    alert("Add Success!");
                    // redirect to /students/view
                    window.location.href = "/students/view";
                }
            });
        }
    });

    $('#gpa').on('input', function() {
        var gpa = $(this).val();
        if (!isValidGPA(gpa)) {
            $(this)[0].setCustomValidity("Invalid GPA. Please enter a valid GPA between 0.00 and 4.33.");
        } else {
            $(this)[0].setCustomValidity('');
        }
    });
});

// function to check valid GPA
function isValidGPA(gpa) {
    var gpaValue = parseFloat(gpa);
    return !isNaN(gpaValue) && gpaValue >= 0.00 && gpaValue <= 4.33;
}
