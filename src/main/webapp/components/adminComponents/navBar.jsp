<div class="flex justify-between p-6 bg-blue-700">
  <div class="flex">
    <div class="flex gap-5 self-center mx-14 mr-20">
      <div>
        <jsp:include page="../../svg/logo.jsp"/>
      </div>
      <div class="text-white font-medium" style="font-size: 17px">
        Simplon
      </div>
    </div>
  </div>

  <div class="flex gap-10 self-center mr-14 text-white">
    <button type="button" id="dropdownDefault" data-dropdown-toggle="dropdown" class="text-sm flex flex-col gap-1">
      <div class="self-center"><jsp:include page="../../svg/rendus.jsp"/></div>
      <div class="self-center">Parametre</div>

    </button>
  </div>

  <!-- Dropdown menu -->
  <div id="dropdown" class="hidden z-10 w-44 bg-white rounded divide-y divide-gray-100 shadow dark:bg-gray-700" style="position: absolute; inset: 0px auto auto 0px; margin: 0px; transform: translate(0px, 10px);" data-popper-reference-hidden="" data-popper-escaped="" data-popper-placement="bottom">
    <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefault">
      <li>
        <a href="/dashboard" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Dashboard</a>
      </li>
      <li>
        <a href="#" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Settings</a>
      </li>
      <li>
        <a href="/admin/logout" class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Se deconnecter</a>
      </li>
    </ul>
  </div>

</div>