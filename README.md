NBA simulator


основные функции:

1. canBeTraded(List<Players> playersFromLeftTeam, List<Players> playersFromRightTeam) {} - возвращает или bool (правая команда согласится) или double (вероятность, что например правая (принимающая обмен) команда согласится)

2. startingFive(Team team) {} - возвращает наиболее вероятную стартовую пятерку игроков

3. predictWinner(Team team1, Team team2) {} - возвращает наиболее вероятного победителя матча, опционально можно еще вероятность победы
