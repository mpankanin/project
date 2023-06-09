# project
CONFERENCE

Projekt - Miłosz Pankanin

Serwis (tylko backend) dla strony do obsługi konferencji IT. Założenia konferencji: 
1.	Konferencja trwa 1 dzień: 26 Kwiecień 2023. 
2.	Rozpoczyna się o godzinie 10:00 a kończy o godzinie 15:45.
3.	Każda prelekcja trwa 1h 45m (15 minut to przerwa na kawę):
	- pierwsza prelekcja rozpoczyna się o 10:00 i trwa do 11:45. 
	- druga rozpoczyna się o 12:00 i kończy o 13:45
	- trzecia rozpoczyna się o 14:00 i kończy o 15:45
4.	W ramach konferencji obsługiwane są 3 różne ścieżki tematyczne prowadzone równolegle. Jeśli użytkownik zapisze się w danej ścieżce na daną godzinę, to nie może już uczęszczać w tym okresie w innej ścieżce, natomiast o innej godzinie najbardziej może wybrać inną ścieżkę. 
5.	Każda prelekcja może pomieścić maksymalnie 5 słuchaczy. 

Portal obsługuje następujące scenariusze:
1. Użytkownik może obejrzeć plan konferencji. 
2. Użytkownik po podaniu swojego loginu może obejrzeć prelekcje na które się zapisał. 
3. Jeżeli prelekcja ma jeszcze wolne miejsca, użytkownik ma możliwość dokonania rezerwacji. Podczas dokonywania rezerwacji powinien podać swój login oraz adres e-mail. 
4. Jeżeli w systemie istnieje już użytkownik z danym loginem, ale z innym adresem e-mail, system powinien zaprezentować komunikat „Podany login jest już zajęty”.
5. Poprawne dokonanie rezerwacji skutkuje wysłaniem powiadomienia użytkownikowi na podany przez niego adres (plik .txt). 
6. Użytkownik może anulować rezerwację. 
7. Użytkownik może zaktualizować swój adres e-mail. 
8. System umożliwia wyświetlenie listy zarejestrowanych użytkowników wraz z ich adresami e-mail. 
9. Wygenerowanie zestawienia dla organizatora:
	- zestawienie wykładów wg zainteresowania (procentowy udział uczestników w danym wykładzie)
	- zestawienie ścieżek tematycznych wg zainteresowania (procentowy udział)


Wskazówki i założenia techniczne: 
1.	Dostęp do usług realizowany za pomocą REST api. 
2.	Zapis danych odbywa się do bazy danych in-memory (H2).  
3.	Nie implementuj rzeczywistego wysyłania powiadomień e-mail. Wystarczy zapis powiadomienia do pliku o nazwie „powiadomienia” z danymi: data wysłania, do, treść. 
4.	Użyto narzędzia Maven do budowania projektu.
5.	Jako środowisko uruchomieniowe użyto Spring boot.
6.	Dołączono krótką instrukcję z adresami url do usług REST wraz z przykładowymi zapytaniami. 
7.  Zapis e-maili odbywa się do pliku email.txt. Znajduję się on w folderze resources. Nie ustawiałem usuwania treści po ponownym włączniu programu.


Projekt powstał przy użyciu java wersja 17, oraz bazy danych H2.
Konsola bazy danych dostępna jest pod standardowym url(/h2-console)
jdbc:h2:mem:conferenceDb / login: conference / password: conf


W celu testowania używałem strony:
www.postman.com

Dokumentacja:

https://documenter.getpostman.com/view/27553136/2s93m3446L
