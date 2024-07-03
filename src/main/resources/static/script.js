 document.getElementById('searchBar').addEventListener('input', function () {
        let filter = this.value.toLowerCase();
        let rows = document.querySelectorAll('#ComponentTable tbody tr');

        rows.forEach(row => {
            let cells = row.querySelectorAll('td');
            let match = false;

            cells.forEach(cell => {
                if (cell.textContent.toLowerCase().includes(filter)) {
                    match = true;
                }
            });

            if (match) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });