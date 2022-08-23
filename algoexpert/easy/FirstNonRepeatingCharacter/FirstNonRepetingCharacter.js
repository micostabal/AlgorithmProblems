function firstNonRepeatingCharacter(string) {
    const present = new Set();
    const repeated = new Set();

    for (let i = 0; i < string.length; i++) {
        let this_character = string.charAt(i);
        if (!present.has(this_character)) {
            present.add(this_character);
        } else if (present.has(this_character) &&!repeated.has(this_character)) {
            repeated.add(this_character);
        }
    }
    const difference = new Set([...present].filter(x => !repeated.has(x)));
    if (difference.size == 0) {
        return -1;
    } else {
        for (let i = 0; i < string.length; i++) {
            if (difference.has(string.charAt(i))) {
                return i;
            }
        }
    }
}


console.log(
    firstNonRepeatingCharacter("abcdcaf")
);