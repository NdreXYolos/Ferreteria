<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>

<title>Guzman Floreano Valeria </title>
</head>
<body> 

 <div class="container">
 <h1>Crud de Factura</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaFactura">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  action="listaFactura" class="simple_form" id="defaultForm2"  method="get">
		       		<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<label class="control-label" for="id_nonbre_filtro">NOMBRE</label>
							  	<input class="form-control" id="id_nonbre_filtro"  name="filtro" placeholder="Ingrese el nombre" type="text" maxlength="30"/>
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary" id="validateBtnw1" >FILTRA</button><br>&nbsp;<br>
						</div>
						<div class="col-md-3">
							<button type="button" data-toggle='modal' onclick="registrar();"  class='btn btn-success' id="validateBtnw2" >REGISTRA</button><br>&nbsp;<br>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="tableAlumno" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>ID</th>
												<th>Numero_factura</th>
												<th>Fecha_factura</th>
												<th>Total_venta</th>
												<th>Estado_factura</th>
												<th>Actualiza </th>
												<th>Elimina </th>
											</tr>
										</thead>
										<tbody>
												     
												<c:forEach items="${facturas}" var="x">
													<tr>
														<td>${x.idFactura}</td>
														<td>${x.numero_factura}</td>
														<td>${x.fecha_factura}</td>
														<td>${x.total_venta}</td>
														<td>${x.estado_factura}</td>
														<td>
															<button type='button' data-toggle='modal' onclick="editar('${x.idFactura}','${x.numero_factura}','${x.fecha_factura}','${x.total_venta}','${x.estado_factura}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																<img src='images/edit.gif' width='auto' height='auto' />
															</button>
														</td>
														<td>
															<button type='button' data-toggle='modal' onclick="eliminar('${x.idFactura}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																<img src='images/delete.gif' width='auto' height='auto' />
															</button>
														</td>
														
													</tr>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
  	 <div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de Factura</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_registra" accept-charset="UTF-8" action="registraFactura" class="form-horizontal"     method="post">
				            <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de la Factura</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_numero_factura">Numero_factura</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_numero_factura" name="numero_factura" placeholder="Ingrese la factura" type="text" maxlength="45"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_fecha_factura">Fecha_factura</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_fecha_factura" name="fecha_factura" placeholder="Ingrese la fecha_factura" type="text" maxlength="45"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_total_venta">Total_venta</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_total_venta" name="total_venta" placeholder="Ingrese total_venta" type="text" maxlength="45"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_estado_factura">Estado_factura</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_estado_factura" name="estado_factura" placeholder="Ingrese el estado_factura" type="text" maxlength="45"/>
		                                        </div>
		                                    </div>  
		                                    
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">REGISTRA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>
  
		 <div class="modal fade" id="idModalActualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza factura</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"  action="actualizaFactura" class="form-horizontal"     method="post">
							<div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de la Factura</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_ID">ID</label>
		                                        <div class="col-lg-5">
		                                           <input class="form-control" id="id_ID" readonly="readonly" name="idFactura" type="text" maxlength="8"/>
		                                        </div>
		                                     </div>
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_numero_factura">Numero_factura</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_act_numero_factura" name="numero_factura" placeholder="Ingrese el Numero_factura" type="text" maxlength="30"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_fecha_factura">Fecha_factura</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_act_fecha_factura" name="fecha_factura" placeholder="Ingrese la fecha_factura" type="text" maxlength="30"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_total_venta">Total_venta</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_act_total_venta" name="total_venta" placeholder="Ingrese total_venta" type="text" maxlength="30"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_estado_factura">Estado_factura</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_act_estado_factura" name="estado_factura" placeholder="Ingrese el estado_factura" type="text" maxlength="30"/>
		                                        </div>
		                                    </div>   
		                                    
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">ACTUALIZA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>

</div>

<script type="text/javascript">
function eliminar(id){	
	$('input[id=id_elimina]').val(id);
	$('#idFormElimina').submit();
}

function registrar(){	
	$('#idModalRegistra').modal("show");
}

function editar(id,numero_factura,fecha_factura,total_venta,estado_factura){	
	$('input[id=id_ID]').val(id);
	$('input[id=id_act_numero_factura]').val(numero_factura);
	$('input[id=id_act_fecha_factura]').val(fecha_factura);
	$('input[id=id_act_total_venta]').val(total_venta);
	$('select[id=id_act_estado_factura]').val(estado_factura);
	$('#idModalActualiza').modal("show");
}

$(document).ready(function() {
    $('#tableAlumno').DataTable();
} );
</script>

<script type="text/javascript">
	$('#id_form_registra').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	numero_factura: {
        		selector : '#id_reg_numero_factura',
                validators: {
                    notEmpty: {
                        message: 'El nombre es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El numero es un campo obligatorio',
                    	min : 5,
                    	max : 100
                    }
                }
            },
        	fecha_factura: {
        		selector : '#id_reg_fecha_factura',
                validators: {
                    notEmpty: {
                        message: 'La fecha es un campo obligatorio'
                    },
                    
                }
            },
        	total_venta: {
        		selector : '#id_reg_total_venta',
                validators: {
                    notEmpty: {
                        message: 'El total es un campo obligatorio'
                    },
                   
                    
                }
            },  
            estado_factura: {
        		selector : '#id_reg_estado_factura',
                validators: {
                    notEmpty: {
                        message: 'El estado es un campo obligatorio'
                    },
                }                 
        }   
    });
</script>

<script type="text/javascript">
	$('#id_form_actualiza').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	numero_factura: {
        		selector : '#id_act_numero_factura',
                validators: {
                    notEmpty: {
                        message: 'El numero es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El numero es un campo obligatorio',
                    	min : 3,
                    	max : 100
                    }
                }
            },
        	fecha_factura: {
        		selector : '#id_act_fecha_factura',
                validators: {
                    notEmpty: {
                        message: 'La fecha es un campo obligatorio'
                    },
                   
                }
            },
        	total_venta: {
        		selector : '#id_act_total_venta',
                validators: {
                    notEmpty: {
                        message: 'El total es un campo obligatorio'
                    },
                   
                }
            },     
            estado_factura: {
        		selector : '#id_act_estado_factura',
                validators: {
                    notEmpty: {
                        message: 'El estado es un campo obligatorio'
                    },
                }
            }}                 

          
        }   
    });
</script>

    
</body>
</html> 