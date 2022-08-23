

function nonConstructibleChange(coins) {
    coins = coins.sort(function(a, b){return a-b});
    let n = coins.length;
    let sum = coins.reduce((a,b)=>a+b);
    let current_index = 0;
    if (coins.length == 0 || coins[0] != 1) {
        return 1;
    }
    for (let i = 2; i < sum + 1; i++) {
        while (coins[current_index] < i && current_index<n) {
            current_index++;
        };
        backwards_count = i;
        for (let j = current_index; j >= 0; j--) {
            if (backwards_count - coins[j] < 0) {
                continue;
            } else {
                backwards_count= backwards_count - coins[j];
                continue;
            }
        }
        if (backwards_count > 0) {
            return i;
        }
    }
    return sum + 1;
}


console.log(nonConstructibleChange([1, 1, 2, 3, 5, 7, 22]));
