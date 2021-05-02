
//Input field validation source: https://www.w3schools.com/howto/howto_js_validation_empty_input.asp

function submitPayment() {
    if ($('#formDropdown').val() == "" ||$('#formEmail').val() == "" || $('#formName').val() == "" || $('#formCardNumber').val() == "" || $('#formDate').val() == "" || $('#formValue').val() == "") {
        alert('Your form has empty fields. Please fill in all fields!')
    } else {
        //API call to post an approved loan
        $.ajax({
            url: '/api/transactions/make/',
            type: "POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                "userId": localStorage.getItem('id'),
                "value": $('#formValue').val(),
                "loanId": $('#formDropdown').val()
            }),
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', localStorage.getItem('AuthorizationHeader'));
            },
            success: function (result) {
                console.log("Payment Sent!");
                alert("The payment has been sent");
                location.href = "/viewTransactions";
                //location.reload(true);

            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        })
    }

}



//API call to get all loans by user
$.ajax({
    url: '/api/loan/byuser/' + localStorage.getItem("id"),
    type: "GET",
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    beforeSend: function (xhr) {
        xhr.setRequestHeader('Authorization', localStorage.getItem('AuthorizationHeader'));
    },
    success: function (result) {
        console.log("Loans successfully fetched");
        console.log(result)

        function buildPendingLoansList(loans) {
            var filteredLoans = loans.filter(loan => loan.applicationStatus == "APPROVED");
            for (i in filteredLoans) {

                var loan = filteredLoans[i]
                var option = "<option value=\"" + loan.id + "\" >" + "$" +  loan.loanAmount + " Loan Type: " + loan.loanType + "</option>"
                $('#formDropdown').append(option)


                // var transactionRow = "<tr class=\"cardRadius\">\n" +
                //     "                            <td id=\"dateTransactionRow" + i + "\">" +  new Date(transaction.date).toLocaleString() +  "</td>\n" +
                //     "                            <td id=\"userIdTransactionRow" + i + "\">" + transaction.userId + "</td>\n" +
                //     "                            <td id=\"idTransactionRow" + i + "\">" + transaction.id + "</td>\n" +
                //     "                            <td id=\"valueTransactionRow" + i + "\">" + "$" + transaction.value + "</td>\n" +
                //     "                        </tr>"
                // $('.transactionHistoryTableBody').append(transactionRow);
            }
        }

        buildPendingLoansList(result);
        //location.href = "/dashboard";
    },
    error: function (xhr, resp, text) {
        console.log(xhr, resp, text);
    }
})