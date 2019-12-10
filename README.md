<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Egzamin 4 - Java zaawansowana, Spring.

Przed przystąpieniem do rozwiązywania zadań przeczytaj poniższe wskazówki

## Jak zacząć?

1. Stwórz [*fork*](https://guides.github.com/activities/forking/) repozytorium z zadaniami.
2. Utwórz projekt Mavena o nazwie **JEE_Exam_4**.
3. Wykonaj poniższe polecenia:
```bash
$ cd ~/folderZprojektami/JEE_Exam_4 // użyj własnej lokalizacji
$ git init
$ git remote add origin https://github.com/CodersLab/WAR_AML_S_01_JEE_Exam_4.git // użyj własnego forka
$ git fetch
$ git branch master origin/master
$ git checkout master

```
**Zwróć szczególną uwagę na adres repozytorium oraz nazwę folderu.**

4. Rozwiąż zadania i skomituj zmiany do swojego repozytorium. Użyj do tego komend `git add nazwa_pliku`.
Jeżeli chcesz dodać wszystkie zmienione pliki użyj `git add .` 
Pamiętaj że kropka na końcu jest ważna!
Następnie skommituj zmiany komendą `git commit -m "nazwa_commita"`
    **Repozytorium może zawierać jedynie katalog `src`, pliki: `pom.xml`, `.gitignore`, `README.md`**
5. Wypchnij zmiany do swojego repozytorium na GitHubie.  Użyj do tego komendy `git push origin master`
6. Stwórz [*pull request*](https://help.github.com/articles/creating-a-pull-request) do oryginalnego repozytorium, gdy skończysz wszystkie zadania.

#### Pamiętaj, że pull request musi być stworzony, aby wykładowca dostał Twoje odpowiedzi.

* podczas egzaminu **możesz** korzystać z notatek, kodu napisanego wcześniej, internetu i prezentacji,
* zabroniona jest jakakolwiek komunikacja z innymi kursantami oraz osobami na zewnątrz.

**Powodzenia!**

----------------------------------------------------------------------------------------

### Zadanie 1 (2 pkt)

1. Uzupełnij zestaw zależności odpowiedzialnych za Spring Context.
2. Uzupełnij zestaw zależności odpowiedzialnych za Spring MVC.
3. Utwórz plik konfiguracyjny aplikacji oraz ewentualne ziarna jeżeli są potrzebne.
4. Skonfiguruj `ViewResolver` tak by zwracać z kontrolera jedynie nazwę widoku, np. `home`;

### Zadanie 2 (2 pkt)

1. Stwórz kontroler o nazwie `Exam5Controller`.
2. Utwórz akcję dostępną pod adresem `/`, która będzie wyświetlać widok o nazwie `home.jsp`;
3. Utwórz akcję dostępną pod adresem `/first/<param1>/<param2>`.
4. Akcja ma ma wyświetlać widok `first.jsp`.
5. Pobierz parametry `param1` oraz `param2`, przekaż do widoku a następnie wyświetl.
6. Oznacz parametry jak przechowywane w sesji.
7. Utwórz akcję dostępną pod adresem `/check`, wyświetlającą w widoku `check.jsp` parametry `param1` oraz `param2` zapisane w sesji.

### Zadanie 3 (3 pkt)

1. Utwórz komponent `FileService`.
2. Utwórz w nim metodę `printDirectories(String path)`, która wyświetli na konsoli wszystkie katalogi ze ścieżki zadanej w parametrze `path`.
3. Wykorzystaj wyrażenia lambda w celu sprawdzania czy element jest katalogiem - możesz skorzystać z metody `isDirectory()` klasy `File`.


### Zadanie 4 (4 pkt)

W kontrolerze `Exam5Controller` napisz akcje akcje:
1. Dostępną pod adresem `/createCookie/{cookieName}/{cookieValue}/{cookieTime}` - 
 Ma ona nastawiać ciasteczko o podanej nazwie na podaną wartość. Ciasteczko ma żyć przez `cookieTime` minut.
2. Dostępną pod adresem `/deleteCookie/{cookieName}` - wyświetla zawartość ciasteczka o podanej nazwie i następnie je usuwa. 
Jeżeli takiego ciasteczka nie ma &ndash; powinien wyświetlać informację "Brak ciasteczka".
3. Dodaj akcję dostępną pod adresem `/listCookie` wyświetlającą listę wszystkich ciasteczek.
4. Dodaj linki w widoku umożliwiające wywołanie akcji usuwania.

### Zadanie 5 (4 pkt)

1. W kontrolerze `Exam5Controller` utwórz akcję dostępną pod adresem `/animals`, ma wyświetlać widok `animal.jsp`.
2. Utwórz klasę `Animal` zawierającą właściwości:
  * id (long)
  * name (String)
  * type (String)
  * status (int) - będzie przyjmował wartości 0 i 1;
3. Utwórz interfejs o nazwie `AnimalDao`  z metodą `getList`  a następnie implementujący go komponent o nazwie `AnimalDaoImpl`
 z metodą `getList`, która będzie zwracać listę obiektów typu `Animal`.
4. Utwórz i dodaj do listy przynajmniej 3 obiekty.
5. Wstrzyknij do kontrolera utworzony komponent, przekaż do widoku i wyświetl pobraną listę zwierząt. 
6. Dodaj akcję dostępną pod adresem `/animals/{id}/delete` - pozwalającą usuwać obiekt z listy.
7. Dodaj akcję dostępną pod adresem `/animals/{id}/status` - pozwalającą zmieniać status obiektu na przeciwny.
8. Ustaw dla powyższych ścieżek wymóg żeby parametr id musiał być licbą (wykorzystaj regex)  
9. Dodaj linki w widoku umożliwiające wywołanie akcji usuwania i zmiany statusu.

### Zadanie 6 (5 pkt)

1. Utwórz klasę o nazwie `Product` - klasa ma zawierać właściwości:
    - typu String o nazwie `name`.
    - typu decimal o nazwie `price`.
    
2. Utwórz klasę o nazwie `History` - klasa ma zawierać właściwość:
 - private List<Product> lastProducts;   
 - getter do tej właściwości
 - metodę `addProduct` pozwalającą dodać element typu `Product` do listy `lastProducts`. 
    
3. Ustal dla klasy `History` zasięg typu sesyjnego:
```java
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)   
```
5. Utwórz kontroler `HistoryController`, wstrzyknij komponent typu `History`.
6. Utwórz akcję dostępną pod adresem `/add-history` :
````java
    @RequestMapping("/add-history")
    @ResponseBody
    public void addToHistory() {
        Random rand = new Random();
        history.addProduct(new Product("prod" + rand.nextInt(10), rand.nextDouble()));
    }
````
7. Utwórz akcję dostępną pod adresem `/show-history` w której wyświetlisz wszystkie produkty z koszyka.

Utwórz w klasach odpowiednie konstruktory - tak by kod działał poprawnie.        