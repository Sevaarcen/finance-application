






//API call to get all transactions loans
$.ajax({
    url: '/api/transactions/get/user/' + localStorage.getItem("id"),
    type: "GET",
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    beforeSend: function (xhr) {
        xhr.setRequestHeader('Authorization', localStorage.getItem('AuthorizationHeader'));
    },
    success: function (result) {
        console.log("Transaction history successfully fetched");
        console.log(result)

        function buildTransactionHistoryTable(transactions) {
            for (i in transactions) {
                var transaction = transactions[i]
                var transactionRow = "<tr class=\"cardRadius\">\n" +
                    "                            <td id=\"dateTransactionRow" + i + "\">" +  new Date(transaction.date).toLocaleString() +  "</td>\n" +
                    "                            <td id=\"userIdTransactionRow" + i + "\">" + transaction.userId + "</td>\n" +
                    "                            <td id=\"idTransactionRow" + i + "\">" + transaction.id + "</td>\n" +
                    "                            <td id=\"valueTransactionRow" + i + "\">" + "$" + transaction.value + "</td>\n" +
                    "                        </tr>"
                $('.transactionHistoryTableBody').append(transactionRow);
            }
        }

        buildTransactionHistoryTable(result);
        //location.href = "/dashboard";
    },
    error: function (xhr, resp, text) {
        console.log(xhr, resp, text);
    }
})