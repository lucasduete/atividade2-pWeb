<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function verificaAtivo() {
                let domStatus = document.getElementById("ativo");
                
                let status = domStatus.value.toLowerCase();
                
                if ((status != "ativo") && (status != "inativo")){
                    alert("Status Invalido");
                    domStatus.value="";
                }
            }
        </script>
    </head>
    <body>
        <h3>Controle de Pedidos!</h3>
        <br/><br/>
        
        <form id="cadastrar" method="POST" action="/atividadePw/controller">
            
            <input type="date" required="true" name="data">
            Valor:<input type="number" required="true" step="0.01" min="0" max="9999" name="valor">
            <br/>
            <input type="text" required="true" placeholder="Nome" name="nome">
            <input type="text" required="true" placeholder="Documento" name="documento">
            Saldo:<input type="number" required="true" step="0.01" min="0" max="9999" name="saldo">
            <input type="text" required="true" placeholder="Status(Ativo ou Inativo)" id="ativo" name="cliente.ativo" onblur="verificaAtivo()">
            <br/>
            
            <input type="submit" value="Enviar">
        </form>
        
        <br/><br/><br/>
        
        <h3>Buscar Pedido</h3>
        
        <form id="buscar" method="GET" action="/atividadePw/controller">
            <input type="text" required="true" name="nomePedido" placeholder="Nome do Pedido">
            <br/>
            <input type="submit">
        </form>
            
    </body>
</html>
