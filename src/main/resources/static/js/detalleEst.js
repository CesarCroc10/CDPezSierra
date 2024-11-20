
function toggleEditMode(idAlumno) {
    const editButton = document.getElementById('edit-button');
    const telefonoSpan = document.getElementById('telefono-span');
    const telefonoInput = document.getElementById('telefono-input');
    const infoMedicaSpan = document.getElementById('info-medica-span');
    const infoMedicaInput = document.getElementById('info-medica-input');

    if (editButton.innerText === "Edit") {
        editButton.innerText = "Guardar";
        telefonoSpan.style.display = "none";
        telefonoInput.style.display = "inline";
        infoMedicaSpan.style.display = "none";
        infoMedicaInput.style.display = "inline";
    } else {
        editButton.innerText = "Edit";
        telefonoSpan.style.display = "inline";
        telefonoInput.style.display = "none";
        infoMedicaSpan.style.display = "inline";
        infoMedicaInput.style.display = "none";

        telefonoSpan.innerText = telefonoInput.value;
        infoMedicaSpan.innerText = infoMedicaInput.value;

        // Pasar el ID del alumno a la función updateData
        updateData(idAlumno, telefonoInput.value, infoMedicaInput.value);
    }
}

function updateData(idAlumno, telefono, infoMedica) {
    const payload = { idAlumno: idAlumno, telefono: telefono, infoMedica: infoMedica };
    const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content'); 
    const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

    console.log('Enviando payload:', payload);

    fetch('/Estudiantes/update', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', [csrfHeader]: csrfToken },
        body: JSON.stringify(payload)
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(error => {
                throw new Error('Error al actualizar los datos: ' + (error.error || response.statusText));
            });
        }
        return response.json();
    })
    .then(data => {
        alert(data.message || 'Datos actualizados correctamente.');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar los datos. ' + error.message);
    });
}

function toggleEditContactos(idAlumno) {
    const editButton = document.getElementById('edit-contactos');
    const contactos = document.querySelectorAll('.info-grid.contactos');

    if (editButton.innerText === "Edit") {
        // Cambiar a modo edición
        editButton.innerText = "Guardar";
        contactos.forEach((contacto, index) => {
            console.log(`Editando contacto ${index}`); // Depuración

            // Mostrar campos editables
            const nombreSpan = document.getElementById(`nombre-span-${index}`);
            const nombreInput = document.getElementById(`nombre-input-${index}`);
            const apellidoSpan = document.getElementById(`apellido-span-${index}`);
            const apellidoInput = document.getElementById(`apellido-input-${index}`);
            const relacionSpan = document.getElementById(`relacion-span-${index}`);
            const relacionInput = document.getElementById(`relacion-input-${index}`);
            const telefonoSpan = document.getElementById(`telefono-span-${index}`);
            const telefonoInput = document.getElementById(`telefono-input-${index}`);

            console.log(`Elementos encontrados para el contacto ${index} - nombreSpan: ${nombreSpan}, nombreInput: ${nombreInput}, apellidoSpan: ${apellidoSpan}, apellidoInput: ${apellidoInput}, relacionSpan: ${relacionSpan}, relacionInput: ${relacionInput}, telefonoSpan: ${telefonoSpan}, telefonoInput: ${telefonoInput}`);

            if (nombreSpan && nombreInput && apellidoSpan && apellidoInput && relacionSpan && relacionInput && telefonoSpan && telefonoInput) {
                nombreSpan.style.display = "none";
                nombreInput.style.display = "inline";
                apellidoSpan.style.display = "none";
                apellidoInput.style.display = "inline";
                relacionSpan.style.display = "none";
                relacionInput.style.display = "inline";
                telefonoSpan.style.display = "none";
                telefonoInput.style.display = "inline";
            } else {
                console.error(`Elementos no encontrados para el contacto: ${index}`);
            }
        });
    } else {
        // Cambiar a modo vista y guardar datos
        editButton.innerText = "Edit";

        const updatedContactos = [];
        contactos.forEach((contacto, index) => {
            const nombreSpan = document.getElementById(`nombre-span-${index}`);
            const nombreInput = document.getElementById(`nombre-input-${index}`);
            const apellidoSpan = document.getElementById(`apellido-span-${index}`);
            const apellidoInput = document.getElementById(`apellido-input-${index}`);
            const relacionSpan = document.getElementById(`relacion-span-${index}`);
            const relacionInput = document.getElementById(`relacion-input-${index}`);
            const telefonoSpan = document.getElementById(`telefono-span-${index}`);
            const telefonoInput = document.getElementById(`telefono-input-${index}`);

            if (nombreSpan && nombreInput && apellidoSpan && apellidoInput && relacionSpan && relacionInput && telefonoSpan && telefonoInput) {
                const nombre = nombreInput.value;
                const apellido = apellidoInput.value;
                const relacion = relacionInput.value;
                const telefono = telefonoInput.value;

                nombreSpan.innerText = nombre;
                nombreSpan.style.display = "inline";
                nombreInput.style.display = "none";
                apellidoSpan.innerText = apellido;
                apellidoSpan.style.display = "inline";
                apellidoInput.style.display = "none";
                relacionSpan.innerText = relacion;
                relacionSpan.style.display = "inline";
                relacionInput.style.display = "none";
                telefonoSpan.innerText = telefono;
                telefonoSpan.style.display = "inline";
                telefonoInput.style.display = "none";

                // Añadir contacto actualizado a la lista
                updatedContactos.push({ nombre, apellido, relacion, telefono });
            } else {
                console.error(`Elementos no encontrados para el contacto: ${index}`);
            }
        });

        // Llamar a la función para guardar en la base de datos
        updateContactos(updatedContactos, idAlumno);
    }
}

function updateContactos(contactos, idAlumno) {
    const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content'); 
    const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
    idAlumno = parseInt(idAlumno, 10); // Convertir a número si es necesario

    console.log('Payload a enviar:', { contactos, idAlumno }); // Depuración

    fetch('/Estudiantes/updateContacto', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', [csrfHeader]: csrfToken },
        body: JSON.stringify({ contactos: contactos, idAlumno: idAlumno }) // Asegurarse de enviar el idAlumno como un número
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(error => {
                throw new Error('Error al actualizar los contactos: ' + (error.error || response.statusText));
            });
        }
        return response.json();
    })
    .then(data => {
        alert(data.message || 'Contactos actualizados correctamente.');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar los contactos. ' + error.message);
    });
}

function toggleEditModeInscripciones() {
    const editButton = document.getElementById('edit-subscriptions');
    const inscripciones = document.querySelectorAll('.subscription-list > ul > li');
    const alumnoId = document.querySelector('.section.subscriptions').getAttribute('data-alumno-id');

    if (editButton.innerText === "Edit") {
        editButton.innerText = "Guardar";
        inscripciones.forEach((inscripcion, index) => {
            const estadoSpan = document.getElementById(`estado-span-${index}`);
            const estadoSwitch = document.getElementById(`estado-switch-${index}`);

            estadoSpan.style.display = "none";
            estadoSwitch.style.display = "inline";
        });
    } else {
        editButton.innerText = "Edit";

        const updatedInscripciones = [];
        inscripciones.forEach((inscripcion, index) => {
            const estadoSpan = document.getElementById(`estado-span-${index}`);
            const estadoSwitch = document.getElementById(`estado-switch-${index}`);

            const isActivo = estadoSwitch.querySelector('input').checked;
            const estado = isActivo ? "Activo" : "Inactivo";

            estadoSpan.innerText = estado;
            estadoSpan.style.display = "inline";
            estadoSpan.className = `estado ${isActivo ? 'estado-activo' : 'estado-inactivo'}`;
            estadoSwitch.style.display = "none";

            // Añadir inscripción actualizada a la lista
            const inscripcionId = inscripcion.getAttribute('data-inscripcion-id');
            updatedInscripciones.push({ id: inscripcionId, estado: estado });
        });

        // Llamar a la función para guardar en la base de datos
        updateInscripciones(updatedInscripciones, alumnoId);
    }
}

function updateInscripciones(inscripciones, alumnoId) {
    const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content'); 
    const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
    fetch('/Estudiantes/updateInscripcion', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', [csrfHeader]: csrfToken},
        body: JSON.stringify({ inscripciones: inscripciones, id_alumno: alumnoId })
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(error => {
                throw new Error('Error al actualizar las inscripciones: ' + (error.error || response.statusText));
            });
        }
        return response.json();
    })
    .then(data => {
        alert(data.message || 'Inscripciones actualizadas correctamente.');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al actualizar las inscripciones. ' + error.message);
    });
}
