const calculate = (function () {
    let cnt = 0;
    let current = 0;
    let klay = 9;
    let currentVal = 0;
    let addLossCalc = 0;
    function test() {
        $.ajax({
            url: 'https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWUSD', // ----- (1)
            cache: false,
            success: function (data) {
                // console.log(data[0].basePrice);
                current = data[0].basePrice;
            },
        });
        $.ajax({
            url: 'https://api.bithumb.com/public/ticker/KLAY', // ----- (1)
            cache: false,
            success: function (data) {
                // console.log(data.data.closing_price);
                let before_klay = data.data.opening_price;
                klay = data.data.closing_price;
                addLossCalc = (before_klay-klay) / before_klay * 100;
                addLossCalc = addLossCalc.toFixed(2);
                console.log(addLossCalc)
                if (before_klay > klay) {
                    addLossCalc *= -1;
                }
            },
        });
        // 1달러 = 1200 * 500
        const res = (klay / current);
        // console.log(res);
        $('#dollor').html(`실시간 dollor 가격 : $1US = ${current}KRW`);
        $('#klay').empty();
        $('#klay').val(klay);
        $('#klay').append(`실시간 KLAY 가격 : ${klay}`);
        $('#test').html(`실시간 KLAY 가격 : $${res}`);

        $('#test2').html(`실시간 KLAY 이익 or 손실 : ￦${addLossCalc}%`);

        $("#coin").on("propertychange change keyup paste input", function() {
            currentVal = $(this).val();
        });

        $('#money').val(currentVal * klay);
    }

    return {
        init: function () {
            test();
        },
    };
})();

window.onload = function () {
    calculate.init();
    setInterval(() => {
        calculate.init();
    }, 500);
};