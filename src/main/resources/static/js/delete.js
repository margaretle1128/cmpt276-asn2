function deleteStudent(uid) {
    if (confirm("Are you sure you want to delete this student?")) {
        $.ajax({
            type: 'POST',
            // send to endpoint /students/delete
            url: '/students/delete',
            data: { uid: uid },
            success: function() {
                // reload webpage
                location.reload();
            }
        });
    }
}