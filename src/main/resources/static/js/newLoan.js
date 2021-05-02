//Source: https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_js_rangeslider_round

var loanRangeSlider = document.getElementById('loanAmountSlider1');
var loanRangeSliderOutput = document.getElementById('loanAmountValue');
loanRangeSliderOutput.innerText = loanRangeSlider.value;

loanRangeSlider.oninput = function () {
    loanRangeSliderOutput.innerHTML = '$' + this.value;
}

//Loan Type Card selection
//Source for toggle technique: https://www.w3schools.com/howto/howto_js_toggle_class.asp
function setCarLoanSelected() {
    var selectedLoanType = document.getElementById("carLoanCard");
    selectedLoanType.classList.toggle("loanTypeSelected");
}

function setPersonalLoanSelected() {
    var selectedLoanType = document.getElementById("personalLoanCard");
    selectedLoanType.classList.toggle("loanTypeSelected");
}

function setProjectLoanSelected() {
    var selectedLoanType = document.getElementById("projectLoanCard");
    selectedLoanType.classList.toggle("loanTypeSelected");
}

function setBusinessLoanSelected() {
    var selectedLoanType = document.getElementById("businessLoanCard");
    selectedLoanType.classList.toggle("loanTypeSelected");
}

function setRenovateLoanSelected() {
    var selectedLoanType = document.getElementById("renovateLoanCard");
    selectedLoanType.classList.toggle("loanTypeSelected");
}

//Loan Tenure Month selected property

function setMonthCardClicked() {
    var monthclicked = document.getElementById("monthCard");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked2() {
    var monthclicked = document.getElementById("monthCard2");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked3() {
    var monthclicked = document.getElementById("monthCard3");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked4() {
    var monthclicked = document.getElementById("monthCard4");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked5() {
    var monthclicked = document.getElementById("monthCard5");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked6() {
    var monthclicked = document.getElementById("monthCard6");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked7() {
    var monthclicked = document.getElementById("monthCard7");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked8() {
    var monthclicked = document.getElementById("monthCard8");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked9() {
    var monthclicked = document.getElementById("monthCard9");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked10() {
    var monthclicked = document.getElementById("monthCard10");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked11() {
    var monthclicked = document.getElementById("monthCard11");
    monthclicked.classList.toggle("monthCardSelected");
}

function setMonthCardClicked12() {
    var monthclicked = document.getElementById("monthCard12");
    monthclicked.classList.toggle("monthCardSelected");
}


function submitLoanApplication() {
    //Loan Amount
    console.log(document.getElementById("loanAmountSlider1").value);

    //Loan Type

    if (document.getElementsByClassName("loanTypeSelected").length == 0) {
        alert("No Loan Type Selected");
        return;
    } else {
        console.log(document.getElementsByClassName("loanTypeSelected")[0].value)
    }

    //Tenure
    console.log(document.getElementById("points").value)

    var newLoan = {
        'type': document.getElementsByClassName("loanTypeSelected")[0].value,
        'amount': Number(document.getElementById("loanAmountSlider1").value),
        'tenure': document.getElementById("points").value,
        'userId': localStorage.getItem('id')
    };
    console.log(newLoan);
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
            alert("Loan application was successful -- you will be contacted by an ATZ Finance employee shortly");
            location.href = "/dashboard";
        },
        error: function (xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })
}