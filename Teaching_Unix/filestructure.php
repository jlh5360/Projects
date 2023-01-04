<?php
	$page = 'Filenames';
    $css = 'subpage.css';
    $script = 'totop.js'; 
	include 'assets/inc/header_&_nav.php';
?>


    <div class="content">

    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

        <h1>File Structure</h1>


        <p>
            Unix is organized in a hierarchical file structure. This allows for easier access and
            maintenance of data. This should be familiar to Microsoft Windows users because they
            use the same structure.
        </p><br>

        <p>The top-level directory is called root(written as slash /). From the root, the tree grows downward.</p><br>

        <p>At the end of each path, an ordinary file or directory will be found. In this diagram, ordinary files are
            rectangles and directories have curved edges.</p><br>

        <p>Ordinary files are normal files. They are files that can hold documents, pictures, programs, and other kinds
            of
            data but do not support other paths.</p><br>

        <p>Directories can hold ordinary files or more directories allowing growth. They are also known as folders.
            Directories directly connected by a path are called parents (closer to the root) and children (farther from
            the
            root).</p><br>

        <img src="assets/img/unixfilestructurediagram.png" width="600" height="600" alt="Unix files structure diagram"
            id="unix_file_structure_diagram">


        <h2>Filenames</h2>
        <p>
            All files have a name. The names for files can reach up to 255 characters long. No two names in a directory
            are the same. If files are in separate directories they can share the same name. In Unix, the operating
            system is case-sensitive. This means you can name a file <strong>monday, Monday, or MONDAY</strong> and this
            would represent three different files.
        </p><br>

        <p>These are the characters you can use to name your files.</p>

        <ul id="characters_list">
            <li>Uppercase letters (A-Z)</li>
            <li>Lowercase letters (a-z)</li>
            <li>Numbers (0-9)</li>
            <li>Underscore( _ )</li>
            <li>Period ( . )</li>
            <li>Comma ( , )</li>
        </ul><br>

        <p>
            A file that begins with a period is called a hidden file. When using the command “ls”, hidden files
            will not appear. Do not worry, you can still see these files if you use the command “ls -a”. We will
            go in-depth about this in a later section.
        </p>

        <h2>Pathnames</h2>
        <p>
            Every file has a pathname. A pathname is a statement of the location of a file or other item in a
            hierarchy of directories.
        </p>
        
        <p>A file can either have a full, also known as an absolute, pathname, or a relative pathname. Full paths 
            give the entire pathname and point the computer to the same location no matter what the working directory 
            is. It is always given in reference to the root directory. A relative path gives only part of the pathname. 
            This leaves the computer to “assume” that the file is in the same directory as the working directory. 
        </p>

        <br>

    </div>

<?php
    include 'assets/inc/footer.php';
?>