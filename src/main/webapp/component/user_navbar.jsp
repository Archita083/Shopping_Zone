<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=request.getContextPath()%>/user/user_homepage.jsp">Home</a></li>

                     <li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=request.getContextPath()%>/user/view_cart.jsp">MyCart</a></li>
						
				    <li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Profile</a></li>

					
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=request.getContextPath()%>/logout_user">Logout</a></li>

				</ul>

			</div>
		</div>
	</nav>