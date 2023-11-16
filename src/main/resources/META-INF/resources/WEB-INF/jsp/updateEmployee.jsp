<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
      <h1>Edit Employee Details</h1>
      <form method="post">
      <fieldset class="mb-3">
                  <label path="id">Id</label>
                  <input type="text" name="id" path="id" required="required" value="${param.id}" readonly/>
              </fieldset>
        <fieldset class="mb-3">
            <label path="name">Name</label>
            <input type="text" name="name" path="name" required="required"/>
        </fieldset>
        <fieldset class="mb-3">
            <label path="designation">Designation</label>
            <input type="text" name="designation" path="designation" required="required"/>
        </fieldset>
        <fieldset class="mb-3">
                    <label path="dateOfBirth">DateOfBirth</label>
                    <input type="date" name="dateOfBirth" path="dateOfBirth" required="required"/>
                </fieldset>
                <fieldset class="mb-3">
                    <label path="salary">Salary</label>
                    <input type="number" name="salary" path="salary" required="required"/>
                </fieldset>

          <input type="submit" class="btn btn-success"/>
      </form>
</div>
<%@ include file="common/footer.jspf" %>
      <script type="text/javascript">
      	$('#targetDate').datepicker({
      	    format: 'yyyy-mm-dd'
      	});
      </script>