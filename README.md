![CI](https://github.com/anroszkiewicz/IOD-L11-Beta/actions/workflows/ci.yml/badge.svg)

# JSON Tools

Aplikacja dla programistów, którzy potrzebują przeformatować lub filtrować struktury danych zapisane w formacie JSON a także porównać ze soba struktury. 
JSON tools pozwala zarówno na zminifikowanie niezminifikowanej reprezentacji JSON, a także na operację odwrotną (z dodaniem wszelkich odstępów i nowych linii).

# Autorzy

- Michał Chojnacki

- Jakub Głowacki

- Krzysztof Jaworski

- Anna Roszkiewicz

# Jak używać

Aplikacja obsługuje metody GET i POST, przykładowo:

```
curl -X GET -H "Content-type: application/json" -d '{"name": "Darth"}' "http://localhost:8080/?transforms=minify,filter,exclude&filterparams=name&excludeparams=surname"
```

Po transforms podajemy listę operacji, które chcemy wykonać na danych wejściowych.

Dostępne operacje:

- minify: pozwala uzyskać zminifikowaną strukturę w formacie JSON na podstawie pełnej

- decompress: pozwala uzyskać pełną strukturę w formacie JSON na podstawie zminifikowanej

- filter: pozwala uzyskać strukturę w formacie JSON zawierającą tylko określone własności

  wymaga podania parametru filterparams z listą własności

- exclude: pozwala uzyskać strukturę w formacie JSON nie zawierającą określonych własności

  wymaga podania parametru excludeparams z listą własności

  ---

  Operacje wykonywane są w kolejności ich wpisania w pole transforms. Zaleca się wykonywanie minifikacji i dekompresji jako ostatnich transformacji (pozostałe transformacje nie zapewniają utrzymania zminifikowanej / zdekowanej formy).]