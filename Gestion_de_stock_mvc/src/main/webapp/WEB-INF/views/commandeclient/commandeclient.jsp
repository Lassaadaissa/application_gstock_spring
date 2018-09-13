<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion de stock mvc</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key = "common.client.commande" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						  <li><a href="<c:url value="/commandeclient/nouveau" />" ><i class="fa fa-plus">&nbsp;<fmt:message key="common.ajouter" /></i></a></li>
						  <li><a href="#"><i class="fa fa-download">&nbsp;<fmt:message key="common.exporter" /></i></a></li>
						  <li><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message key="common.importer" /></i></a></li>
						</ol>					
					</div>                
                </div>
                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message key="commande.client.liste" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th><fmt:message key="common.code" /></th>
                                        <th><fmt:message key="common.date" /></th>
                                        <th><fmt:message key="common.client" /></th>
                                        <th><fmt:message key="common.total" /></th>
                                        <th><fmt:message key="common.actions" /></th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${commandesClient }" var = "cde">
                                		<tr>
	                                		<td>${cde.getCode() }</td>
	                                		<td>${cde.getDateCommande() }</td>
	                                		<td>${cde.getClient().getNom() }</td>
	                                		<td>${cde.getTotalCommande() }</td>
	                               			<td>
	                               				<textArea id = "json${cde.getIdCommandeClient() }" style="display: none;">${cde.getLigneCommandeJson() }  </textArea>
	                                        	<button class="btn btn-link" onclick="updateDetailCommande(${cde.getIdCommandeClient() });"><i class="fa fa-th-list"></i></button>
	                                        	&nbsp;|&nbsp;
	                                        	<c:url value="/commandeclient/modifier/${cde.getIdCommandeClient() }" var="urlModif" />
	                                        	<a href="${urlModif }"><i class="fa fa-edit"></i></a>
	                                        	&nbsp;|&nbsp;
	                                        	<a href="javascript:void(0);" data-toggle="modal" data-target="#modalcommande${cde.getIdCommandeClient() }"><i class="fa fa-trash-o"></i></a>
	                                        	<div class="modal fade" id="modalcommande${cde.getIdCommandeClient() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																<h4 class="modal-title" id="myModalLabel"><fmt:message key="common.confirm.suppression" /></h4>
															</div>
															<div class="modal-body">
																<fmt:message key="article.confirm.suppression.msg" />
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="common.annuler" /></button>
																<c:url value="/commandeclient/supprimer/${cde.getIdCommandeClient() }" var="urlSuppression" />
																<a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;<fmt:message key="common.confirmer" /></a>
															</div>
														</div>
														<!-- /.modal-content -->
													</div>
													<!-- /.modal-dialog -->
												</div>
	                                        </td>
                                        </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- Details de la commande -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message key="commande.client.detail" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th><fmt:message key="common.article" /></th>
                                        <th><fmt:message key="common.qte" /></th>
                                        <th><fmt:message key="common.prixUnitTTC" /></th>
                                        <th><fmt:message key="common.total" /></th>
                                    </tr>
                                </thead>
                                <tbody id = "detailCommande">
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
    <!-- My Custom JavaScript files -->
    <script src="<%=request.getContextPath() %>/resources/javascript/commandeClient.js"></script>

</body>

</html>