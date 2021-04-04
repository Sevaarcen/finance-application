//Source: https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_js_rangeslider_round

var loanRangeSlider = document.getElementById('loanAmountSlider1');
var loanRangeSliderOutput = document.getElementById('loanAmountValue');
loanRangeSliderOutput.innerText = loanRangeSlider.value;

loanRangeSlider.oninput = function () {
    loanRangeSliderOutput.innerHTML = '$' + this.value;
}

function recordNewLoan() {

    var newLoan = {
        'type': document.getElementByID('icons-sm'),
        'value': loanRangeSliderOutput,
        'userID': localStorage.getItem('id')
    };
    //API call to post this new loan application to the loan application database
    $.ajax({
        url: '/api/loan/request',
        type: "POST",
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(newLoan),
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', localStorage.getItem('AuthorizationHeader'));
        },
        success: function (result) {
            console.log("Successfully submitted!");
            location.reload();
        },
        error: function (xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })

}