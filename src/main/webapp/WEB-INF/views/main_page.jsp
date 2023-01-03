<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<tiles:insertAttribute name="header" />
<style>
        #loader {
            border: 12px solid #f3f3f3;
            border-radius: 50%;
            border-top: 12px solid #444444;
            width: 70px;
            height: 70px;
            animation: spin 1s linear infinite;
        }

        @keyframes spin {
            100% {
                transform: rotate(360deg);
            }
        }

        .center {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
        }
    </style>
</head>
<body>

	<tiles:insertAttribute name="content" />

</body>

<footer>
<tiles:insertAttribute name="footer" />
</footer>
</html>