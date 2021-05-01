
//Input field validation source: https://www.w3schools.com/howto/howto_js_validation_empty_input.asp

function submitPayment() {
    if ($('#formEmail').val() == "" || $('#formName').val() == "" || $('#formCardNumber').val() == "" || $('#formDate').val() == "" || $('#formValue').val() == "") {
        alert('Your form has empty fields. Please fill in all fields!')
    }

}