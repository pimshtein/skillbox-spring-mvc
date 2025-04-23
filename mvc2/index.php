<?php
// Подключение к базе данных PostgreSQL
$host = 'localhost';
$port = '5432';
$dbname = 'bnpl';
$user = 'bnpl';
$password = 'bnpl';

// Устанавливаем соединение с PostgreSQL
$conn = pg_connect("host=$host port=$port dbname=$dbname user=$user password=$password");

// Проверяем соединение
if (!$conn) {
    die('Ошибка подключения: ' . pg_last_error());
}

// Получаем ID новости из GET-параметра
$news_id = isset($_GET['id']) ? (int)$_GET['id'] : 1;

// Выполняем SQL-запрос для получения новости
$sql = "SELECT id, title, description FROM news WHERE id = $news_id";
$result = pg_query($conn, $sql);

// Проверяем, есть ли результат
if ($result && pg_num_rows($result) > 0) {
    // Извлекаем данные новости
    $news = pg_fetch_assoc($result);
} else {
    die('Новость не найдена.');
}

// Закрываем соединение с базой данных
pg_close($conn);
?>

// Вывод данных пользователю, генерация HTML
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo htmlspecialchars($news['title']); ?></title>
</head>
<body>
<h1><?php echo htmlspecialchars($news['title']); ?></h1>
<p><?php echo nl2br(htmlspecialchars($news['description'])); ?></p>
</body>
</html>