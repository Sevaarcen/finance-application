var carLoanCard = "                                <button class=\"loanOptionCard cardRadius\" id=\"carLoanCard\" value=\"Car\">\n" +
    "                                    <div class=\"loanOptionCardTopRow\">\n" +
    "                                        <h4>Car</h4>\n" +
    "                                        <svg id=\"icons-sm\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-2 -2 24 24\" preserveAspectRatio=\"xMinYMin\" class=\"icon__icon\"><path d=\"M14 17H6v1.5A1.5 1.5 0 0 1 4.5 20h-1A1.5 1.5 0 0 1 2 18.5v-1.67A3.001 3.001 0 0 1 0 14v-3c0-.62.188-1.196.51-1.674l1.086-6.8A3 3 0 0 1 4.56 0h10.88A3 3 0 0 1 18.4 2.527l1.083 6.79c.326.48.516 1.06.516 1.683v3a3.001 3.001 0 0 1-2 2.83v1.67a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5V17zm3.25-8.99l-.824-5.168A1 1 0 0 0 15.44 2H4.559a1 1 0 0 0-.988.842l-.825 5.169A3.04 3.04 0 0 1 3 8h14c.084 0 .168.003.25.01zM15.5 14a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3zm-11 0a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3zm.704-10.906a1 1 0 0 1 1 1v2a1 1 0 1 1-2 0v-2a1 1 0 0 1 1-1z\"></path></svg>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"loanOptionCardBottomRow\">\n" +
    "                                        <h5 style=\"font-weight: lighter\">Loan for Vehicles</h5>\n" +
    "                                    </div>\n" +
    "                                </button>"

var personalLoanCard = "                            <button class=\"loanOptionCard cardRadius\" id=\"personalLoanCard\" value=\"Personal\">\n" +
    "                                <div class=\"loanOptionCardTopRow\">\n" +
    "                                    <h4>Personal</h4>\n" +
    "                                    <svg id=\"icons-sm\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-2 -5 24 24\" preserveAspectRatio=\"xMinYMin\" class=\"icon__icon\"><path d=\"M2 0h16a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm0 2v10h16V2H2zm9 2h5a1 1 0 0 1 0 2h-5a1 1 0 0 1 0-2zm0 3h5a1 1 0 0 1 0 2h-5a1 1 0 0 1 0-2zM4 4h3a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V5a1 1 0 0 1 1-1z\"></path></svg>\n" +
    "                                </div>\n" +
    "                                <div class=\"loanOptionCardBottomRow\">\n" +
    "                                    <h5 style=\"font-weight: lighter\">Loan for Personal Use</h5>\n" +
    "                                </div>\n" +
    "                            </button>"

var projectLoanCard = "                            <button class=\"loanOptionCard cardRadius\" id=\"projectLoanCard\" value=\"Project\">\n" +
    "                                <div class=\"loanOptionCardTopRow\">\n" +
    "                                    <h4>Project</h4>\n" +
    "                                    <svg id=\"icons-sm\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"feather feather-box\"><path d=\"M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z\"></path><polyline points=\"3.27 6.96 12 12.01 20.73 6.96\"></polyline><line x1=\"12\" y1=\"22.08\" x2=\"12\" y2=\"12\"></line></svg>\n" +
    "                                </div>\n" +
    "                                <div class=\"loanOptionCardBottomRow\">\n" +
    "                                    <h5 style=\"font-weight: lighter\">Loan for Personal Projects</h5>\n" +
    "                                </div>\n" +
    "                            </button>"

var businessLoanCard = "                            <button class=\"loanOptionCard cardRadius\" id=\"businessLoanCard\" value=\"Business\">\n" +
    "                                <div class=\"loanOptionCardTopRow\">\n" +
    "                                    <h4>Business</h4>\n" +
    "                                    <svg id=\"icons-sm\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"feather feather-briefcase\"><rect x=\"2\" y=\"7\" width=\"20\" height=\"14\" rx=\"2\" ry=\"2\"></rect><path d=\"M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16\"></path></svg>\n" +
    "                                </div>\n" +
    "                                <div class=\"loanOptionCardBottomRow\">\n" +
    "                                    <h5 style=\"font-weight: lighter\">Loan for Business</h5>\n" +
    "                                </div>\n" +
    "                            </button>"

var renovateLoanCard = "                            <button class=\"loanOptionCard cardRadius\" id=\"renovateLoanCard\" value=\"Renovate\">\n" +
    "                                <div class=\"loanOptionCardTopRow\">\n" +
    "                                    <h4>Renovate</h4>\n" +
    "                                    <svg id=\"icons-sm\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"feather feather-tool\"><path d=\"M14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.77-3.77a6 6 0 0 1-7.94 7.94l-6.91 6.91a2.12 2.12 0 0 1-3-3l6.91-6.91a6 6 0 0 1 7.94-7.94l-3.76 3.76z\"></path></svg>\n" +
    "                                </div>\n" +
    "                                <div class=\"loanOptionCardBottomRow\">\n" +
    "                                    <h5 style=\"font-weight: lighter\">Loan for Renovations</h5>\n" +
    "                                </div>\n" +
    "                            </button>"



buildPendingLoansTable([1,2,3])
buildProcessedLoansTable([1,2,3])
$('.hidden_row').toggle();


//Source for expanding table rows: https://www.geeksforgeeks.org/how-to-make-html-table-expand-on-click-using-javascript/
//Source for rotating Chevrons: https://stackoverflow.com/questions/23098309/svg-rotation-using-javascript
function toggleTableRows(row) {
    if(document.getElementById(row + "chevron").getAttribute("transform") == "rotate(180)") {
        document.getElementById(row + "chevron").setAttribute("transform", "rotate(0)")
    } else {
        document.getElementById(row + "chevron").setAttribute("transform", "rotate(180)")
    }

    $("#" + row).toggle();

}




function approveLoan() {
}

//Source for getting current row clicked in jQuery: https://stackoverflow.com/questions/13152369/get-current-rowindex-of-table-in-jquery/44679710
//Source for getting appropriate table row with jQuery: https://stackoverflow.com/questions/14460421/get-the-contents-of-a-table-row-with-a-button-click
//Approve Buttons
$("#approveLoanButton1").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput1').val()))
});

$("#approveLoanButton2").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput2').val()))
});
$("#approveLoanButton3").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput3').val()))
});
$("#approveLoanButton4").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput4').val()))
});
$("#approveLoanButton5").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput5').val()))
});
$("#approveLoanButton6").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput6').val()))
});
$("#approveLoanButton7").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput7').val()))
});
$("#approveLoanButton8").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput8').val()))
});
$("#approveLoanButton9").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput9').val()))
});
$("#approveLoanButton10").click(function(){
    var loanID = $(this).parent().parent().prev().children()[4];
    console.log(loanID.innerText)
    console.log(parseFloat($('#interestRateInput10').val()))
});



//Rejection Buttons
$('#rejectLoanButton1, #rejectLoanButton2, #rejectLoanButton3').click(function () {
    alert("Loan Rejected")
})


function buildPendingLoansTable(loans) {
    for (loan in loans) {
        var i = loans[loan]
        var pendingLoansRow = "<tr class=\"tableRowRadius\" onclick=\"toggleTableRows('hidden_row" + i + "')\">\n" +
            "                            <td><svg id=\"hidden_row" + i + "chevron\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-5 -8 24 24\" width=\"24\" height=\"24\" preserveAspectRatio=\"xMinYMin\" class=\"icon__icon\"><path d=\"M7.071 5.314l4.95-4.95a1 1 0 1 1 1.414 1.414L7.778 7.435a1 1 0 0 1-1.414 0L.707 1.778A1 1 0 1 1 2.121.364l4.95 4.95z\"></path></svg></td>\n" +
            "                            <td id=\"firstRow" + i + "\">cell2_1</td>\n" +
            "                            <td id=\"lastRow" + i + "\">cell3_1</td>\n" +
            "                            <td id=\"dateRow" + i + "\">cell4_1</td>\n" +
            "                            <td id=\"idRow" + i + "\">cell5_1</td>\n" +
            "                            <td id=\"amountRow" + i + "\">cell6_1</td>\n" +
            "                            <td id=\"statusRow" + i + "\">Pending</td>\n" +
            "                        </tr>\n" +
            "                        <tr id=\"hidden_row" + i + "\" class=\"hidden_row\">\n" +
            "                            <td>\n" +
            "                                <h3>Type:</h3>\n" +
            "                            </td>\n" +
            "                            <td class=\"pendingLoansTableExpanded\">\n" +
            "                                <button class=\"loanOptionCard cardRadius\" id=\"carLoanCard\" value=\"Car\" onclick=\"setCarLoanSelected()\">\n" +
            "                                    <div class=\"loanOptionCardTopRow\">\n" +
            "                                        <h4>Car</h4>\n" +
            "                                        <svg id=\"icons-sm\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-2 -2 24 24\" preserveAspectRatio=\"xMinYMin\" class=\"icon__icon\"><path d=\"M14 17H6v1.5A1.5 1.5 0 0 1 4.5 20h-1A1.5 1.5 0 0 1 2 18.5v-1.67A3.001 3.001 0 0 1 0 14v-3c0-.62.188-1.196.51-1.674l1.086-6.8A3 3 0 0 1 4.56 0h10.88A3 3 0 0 1 18.4 2.527l1.083 6.79c.326.48.516 1.06.516 1.683v3a3.001 3.001 0 0 1-2 2.83v1.67a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5V17zm3.25-8.99l-.824-5.168A1 1 0 0 0 15.44 2H4.559a1 1 0 0 0-.988.842l-.825 5.169A3.04 3.04 0 0 1 3 8h14c.084 0 .168.003.25.01zM15.5 14a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3zm-11 0a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3zm.704-10.906a1 1 0 0 1 1 1v2a1 1 0 1 1-2 0v-2a1 1 0 0 1 1-1z\"></path></svg>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"loanOptionCardBottomRow\">\n" +
            "                                        <h5 style=\"font-weight: lighter\">Loan for Vehicles</h5>\n" +
            "                                    </div>\n" +
            "                                </button>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <h3>Tenure:</h3>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <h4>8 months</h4>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <label for=\"interestRateInput" + i + "\" style=\"font-weight: bold\">Interest Rate: (%)</label>\n" +
            "                                <input type=\"number\" id=\"interestRateInput" + i + "\" />\n" +
            "                            </td>\n" +
            "                            <td></td>\n" +
            "                            <td>\n" +
            "                                <button id=\"approveLoanButton" + i + "\" class=\"approveLoanButton\" onclick=\"approveLoan()\">Approve</button>\n" +
            "                                <button id=\"rejectLoanButton" + i + "\" class=\"rejectLoanButton\">Reject</button>\n" +
            "                            </td>\n" +
            "                        </tr>";
        $('.pendingLoansTableBody').append(pendingLoansRow);
    }
}


function buildProcessedLoansTable(loans) {
    for (loan in loans) {
        var i = loans[loan]
        var processedLoansRow = "<tr class=\"cardRadius\">\n" +
            "                            <td id=\"lastProcessedRow" + i + "\">cell2_1</td>\n" +
            "                            <td id=\"idProcessedRow" + i + "\">cell3_1</td>\n" +
            "                            <td id=\"statusProcessedRow" + i + "\">Approved</td>\n" +
            "                        </tr>"
        $('.processedLoansTableBody').append(processedLoansRow);
    }
}

