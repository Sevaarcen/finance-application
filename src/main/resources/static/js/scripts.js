//Source: https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_js_rangeslider_round

var loanRangeSlider = document.getElementById('loanAmountSlider1');
var loanRangeSliderOutput = document.getElementById('loanAmountValue');
loanRangeSliderOutput.innerText = loanRangeSlider.value;

loanRangeSlider.oninput = function () {
    loanRangeSliderOutput.innerHTML = '$' + this.value;
}