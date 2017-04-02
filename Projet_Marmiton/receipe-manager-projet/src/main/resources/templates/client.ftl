<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <link href="css/style.css" rel="stylesheet" />
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
    <div class="container_fluid">
            <section id="search">
                <div class="row">
                    <h1 class="text-center">Look for a receiprout !</h1>
                    <form action="">
                        <div id=search-bar" class="input-group stylish-input-group">
                            <input type="text" class="form-control" name="receipeName" placeholder="Search" />
                            <span class="input-group-addon">
                                <button name="action" value="searchByReceipeName" type="submit">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                    </form>
                </div>
            </section>
            <section id="recette">
                <ul>
                <#list receipes as receipe>
                    <li>${receipe_index} - ${receipe.getTitle()}</li>
                </#list>
                </ul>
            </section>
    </div>
</body>
</html>