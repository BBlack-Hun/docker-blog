const calculate = (function () {
    let cnt = 0;
    let current = 0;
    let klay = 9;
    let currentVal = 0;
    let currentVal2 = 0;
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

                if (before_klay > klay) {
                    addLossCalc = (before_klay-klay) / before_klay * 100;
                    addLossCalc = addLossCalc.toFixed(2);
                    addLossCalc *= -1;
                    $('#test2').css('color', 'blue');
                } else {
                    addLossCalc = (klay - before_klay) / before_klay * 100;
                    addLossCalc = addLossCalc.toFixed(2);
                    $('#test2').css('color', 'red');
                }
            },
        });
        // 1달러 = 1200 * 500
        const res = (klay / current);
        // console.log(res);
        // $('#dollor').html(`실시간 dollor 가격 : $1US = ${current}KRW`);
        $('#klay').empty();
        $('#klay').val(klay);
        $('#klay').append(`실시간 KLAY 가격 : ${klay}`);
        $('#test').html(`실시간 KLAY 가격 : $${res}`);

        $('#test2').html(`${addLossCalc}%`);

        $("#money").on("propertychange change keyup paste input", function() {
            currentVal = $(this).val();
        });

        $('#coin').val((currentVal / klay).toFixed(8));

        $("#recoin").on("propertychange change keyup paste input", function() {
            currentVal2 = $(this).val();
        });

        $('#remoney').val((currentVal2 * klay).toFixed(8));
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