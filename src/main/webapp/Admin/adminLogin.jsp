<jsp:include page="../components/header.jsp"/>

<section class="flex justify-center h-full gradient-form bg-gray-200 md:h-screen">
    <div class="container py-12 px-6 h-full">
        <div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
            <div class="xl:w-10/12">
                <div class="block bg-white shadow-lg rounded-lg">
                    <div class="lg:flex lg:flex-wrap g-0">
                        <div class="lg:w-6/12 px-4 md:px-0">
                            <div class="md:p-12 md:mx-6">
                                <div class="text-center">
                                    <h4 class="text-xl font-semibold mt-1 mb-12 pb-1">Admin</h4>
                                </div>
                                <p class="mb-4">Please login to your account</p>
                                <form action="/dashboard" class="mb-4" method="POST">
                                    <input
                                        type="text"
                                        class="mb-4 form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                        placeholder="Username"
                                        name="username"
                                    />
                                    <input
                                        type="password"
                                        class="mb-4 form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                        placeholder="Password"
                                        name="password"
                                    />

                                    <div class="text-center pt-1 mb-12 pb-1">
                                        <button
                                            class="bg-blue-700 inline-block px-6 py-2.5 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:shadow-lg focus:outline-none focus:ring-0 active:shadow-lg transition duration-150 ease-in-out w-full mb-3"
                                            type="submit"
                                            data-mdb-ripple="true"
                                            data-mdb-ripple-color="light"
                                            style="">
                                            Log in
                                        </button>
                                        <a class="text-gray-500" href="#">Forgot password?</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div
                            class="bg-blue-700 lg:w-6/12 flex items-center lg:rounded-r-lg rounded-b-lg lg:rounded-bl-none"
                        >
                            <div class="text-white px-4 py-6 md:p-12 md:mx-6">
                                <h4 class="text-xl font-semibold mb-6">La plateforme collaborative d'apprentissage en pedagogie active</h4>
                                <p class="text-sm">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                    consequat.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>