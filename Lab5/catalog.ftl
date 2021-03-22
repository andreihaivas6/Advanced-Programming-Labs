<html>
<head>
    <title>Catalog</title>
    <style>
        body {
            background-color: aquamarine;
        }
        h1, h2, h3, li {
            margin-left: 50px;
        }
    </style>
</head>
<body>
    <h1>Catalog HTML</h1>
    <h3>Nume catalog: ${nume}</h3>
    <h3>Lista elemente:</h3>
    <ul>
        <#list items as item>
            <fieldset> <legend> Item no. ${item_index + 1}</legend>
                <li>   ${item} </li> </fieldset>
        </#list>
    </ul>
</body>
</html>
