#### Задание: разработать однопоточное приложение согласно теме, указанной ниже. Приложение может быть как консольным, так и оконным (по выбору).
#### Требования к коду лабораторной работы
* Данные приложения хранятся либо в текстовом файле, либо в xml-файле,  либо  в  csv-  файле.  Формат  хранения  данных  разрабатывается  самостоятельно. Повторно файл считывается только при его модификации  (т. к. приложение однопоточное, синхронизацию доступа к источнику 
данных можно не реализовывать).
* Терминальных  классов-сущностей  (классов,  от  которых  создаются объекты) в приложении должно быть не менее пяти. Учтите все требования Java Beans при реализации этих классов. Также учтите возможность  для  проектируемых  классов-сущностей  естественной сортировки (natural order) в предметной области.
* Создайте функционал CRUD для приложения.
* Реализуйте возможность поиска и сортировки данных по набору параметров. Для реализации правил сортировки используйте интерфейс Comparator.
* При реализации приложения придерживайтесь концепций архитектурных паттернов MVC и Layered Architecture.
* Код должен быть документирован (javadoc), документация сгенерирована.
* При написании приложения обязательно использовать Java Code 
Convenion.