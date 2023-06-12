function deleteStudent(uid) {
    if (confirm("Are you sure you want to delete this student?")) {
        $.ajax({
            type: 'POST',
            url: '/students/delete',
            data: { uid: uid },
            success: function() {
                location.reload();
            }
        });
    }
}