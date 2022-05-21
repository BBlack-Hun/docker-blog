const calculate = (function () {
    let cnt = 0;
    let current = 0;
    let klay = 9;
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
                klay = data.data.closing_price;
            },
        });
        // 1달러 = 1200 * 500
        const res = (klay / current);
        console.log(res);
        $('#dollor').html(`실시간 dollor 가격 : $1US = ${current}KWN`);
        $('#klay').html(`실시간 KLAY 가격 : ${klay}`);
        $('#test').html(`실시간 KLAY 가격 : $${res}`);

    }

    return {
        init: function () {
            test();
        },
    };
})();

window.onload = function () {
    setTimeout(() => {
        setInterval(() => {
            calculate.init();
        }, 500);
    }, 1000);
};