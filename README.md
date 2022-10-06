## Домашнее задание по теме «Потоки ввода-вывода. Работа с файлами. Сериализация»

# Задача 2 (обязательная)

Эту задачу делаем в том же репозитории. Отведите ветку serial от main, в которой находится решение первой задачи.

В этом задании мы будем сохранять и восстанавливать корзину покупок через встроенную сериализацию в Java.

Добавьте метод saveBin(File file) для сохранения в файл в бинарном формате.

Добавьте метод static loadFromBinFile(File file) для загрузки корзины из бинарного файла.

Используйте для этого сериализацию и десериализацию. Замените в main сохранение и загрузку из текстового файла на бинарный (название пусть будет basket.bin).

Коммит и пуш в ветку serial.