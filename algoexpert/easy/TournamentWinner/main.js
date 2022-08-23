function tournamentWinner(competitions, results) {
	
	var winner = null;
	var current_winner = null;
	var max_score = 0;
	var scores = {};
  
	for (let i = 0; i < competitions.length; i++) {
		
		let [home_team, away_team] = competitions[i];
		
        current_winner = results[i] == 1 ? home_team.toString() : away_team.toString();
		
        scores[current_winner]? scores[current_winner]+=1 : scores[current_winner]=1

		if (scores[current_winner] > max_score) {
			max_score = scores[current_winner];
			winner = current_winner;
		}
	}
	
    return winner;
}

let c1 = [
    ["HTML", "C#"],
    ["C#", "Python"],
    ["Python", "HTML"]
];

let results = [0, 0, 1];

console.log(
    tournamentWinner(c1, results)
);