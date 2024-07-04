// validateAssembly.js

function validateAssembly() {
    var gpuPrice = document.querySelector('input[name="gpuPrice"]');
    var cpuPrice = document.querySelector('input[name="cpuPrice"]');
    var motherboardPrice = document.querySelector('input[name="motherboardPrice"]');
    var psuPrice = document.querySelector('input[name="psuPrice"]');
    var casePrice = document.querySelector('input[name="casePrice"]');
    var coolerPrice = document.querySelector('input[name="coolerPrice"]');
    var storagePrice = document.querySelector('input[name="storageIds"]');
    var ramPrice = document.querySelector('input[name="ramIds"]');

    var missingComponents = [];

    if (!gpuPrice || !gpuPrice.value) missingComponents.push("grafičku kartu");
    if (!cpuPrice || !cpuPrice.value) missingComponents.push("procesor");
    if (!motherboardPrice || !motherboardPrice.value) missingComponents.push("matičnu ploču");
    if (!psuPrice || !psuPrice.value) missingComponents.push("napajanje");
    if (!casePrice || !casePrice.value) missingComponents.push("kućište");
    if (!coolerPrice || !coolerPrice.value) missingComponents.push("kuler");
        if (!storagePrice || !storagePrice.value) missingComponents.push("storage");
        if (!ramPrice || !ramPrice.value) missingComponents.push("ram");

    if (missingComponents.length > 0) {
        alert("Niste izabrali sledeće komponente: " + missingComponents.join(", "));
        return false;
    }

    return true;
}

// Add event listeners when the DOM is fully loaded
document.addEventListener('DOMContentLoaded', function() {
    var assemblyForm = document.getElementById('assemblyForm');
    if (assemblyForm) {
        assemblyForm.addEventListener('submit', function(event) {
            if (!validateAssembly()) {
                event.preventDefault(); // Prevent form submission if validation fails
            }
        });
    }

    var saveButton = document.getElementById('saveButton');
    if (saveButton) {
        saveButton.addEventListener('click', function(event) {
            if (validateAssembly()) {
                assemblyForm.submit(); // Submit the form if validation passes
            }
        });
    }
});