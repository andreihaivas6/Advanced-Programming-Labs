<html>
<head>
    <title>Catalog</title>
    <style>
        body {
            background-color: aquamarine;
            margin: 25px;
        }
        h1, h2, h3, li {
            margin-left: 50px;
        }
        fieldset {
            border-radius: 30px;
        }
    </style>
</head>
<body>
    <h1>Baza de date</h1>

    <fieldset>
        <legend>Filme</legend>
        <ul>
            <#list items1 as item1>
                <li>   ${item1} </li>
            </#list>
        </ul>
    </fieldset>

    <h2>Persoane</h2>
    <ul>
        <#list items2 as item2>
            <li>   ${item2} </li>
        </#list>
    </ul>
    <h2>Genuri</h2>
    <ul>
        <#list items3 as item3>
            <li>   ${item3} </li>
        </#list>
    </ul>
</body>
</html>
