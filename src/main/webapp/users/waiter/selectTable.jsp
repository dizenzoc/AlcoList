<html>
<head>
    <title>Le mie info</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery.session@1.0.0/jquery.session.min.js"></script>
    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/style/base.css" rel="stylesheet">
</head>
<body>
<%@include file="../../navBar.jsp"%>
<script>
    if(!roleList.includes("WAITER"))
    {
        logout();
    }
</script>
    <div class="title">
        <h1 class="h1">Dashboard</h1>
    </div>
    <div class="container-fluid">
        <div class="content">
            <div class="row row-cols-sm-1 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 gx-1 gy-4 containerTables">

            </div>
        </div>
    </div>
    <script>
        $(document).ready(function()
        {
            for(let i=1; i<11; i++)
            {
                $(".containerTables").append('<div class="col d-flex justify-content-center text-center"><div class="card cardTable"> <div class="card-body"><h5 class="card-title mt-2">&nbsp;</h5><p class="card-text h1 mt-5">'+i+'</p></div></div>')
            }
        });
    </script>
    <style>
        .cardTable
        {
            height: 16rem;
            width: 16rem;
            color: var(--white);
            background-color: var(--secondaryBlue);
            border: 2px solid var(--lightBlue);
        }

        .cardTable:hover
        {
            color: var(--yellow);
            border-color: var(--yellow);
            cursor: pointer;
            transition: 0.3s;
        }
    </style>
</body>
</html>
