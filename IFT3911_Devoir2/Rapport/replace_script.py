import sys

with open("/Users/mostafa/Downloads/Rapport/index.html", "r") as f:
    lines = f.readlines()

# The section starts at <!-- ===================== 4.4 GRAPHE I/A ===================== -->
# which is around line 559
start_idx = -1
end_idx = -1
for i, line in enumerate(lines):
    if "<!-- ===================== 4.4 GRAPHE I/A ===================== -->" in line:
        start_idx = i
    if "<!-- ===================== 4.5 PRINCIPES DE CONCEPTION ===================== -->" in line:
        end_idx = i
        break

if start_idx != -1 and end_idx != -1:
    new_content = """        <!-- ===================== 4.4 GRAPHE I/A ===================== -->
        <div class="analyse" id="graphe-ia">
            <h3>4.4 Graphe Instabilité / Abstraction (I/A)</h3>

            <h4>Formules utilisées</h4>
            <ul>
                <li><strong>Instabilité (I)</strong> = C<sub>e</sub> / (C<sub>a</sub> + C<sub>e</sub>)
                    &nbsp;— où C<sub>a</sub> correspond aux dépendances entrantes et C<sub>e</sub> aux dépendances sortantes.</li>
                <li><strong>Abstraction (A)</strong> = N<sub>a</sub> / N<sub>c</sub>
                    &nbsp;— où N<sub>a</sub> est le nombre de classes abstraites et N<sub>c</sub> est le nombre total de classes dans le paquet.</li>
                <li><strong>Distance (D)</strong> = |A + I − 1| &nbsp;— idéalement D ≈ 0 (sur la Main Sequence).</li>
            </ul>

            <p>Selon le principe du SAP un paquet stable devrait être plus abstrait. Dans notre design, nous avons donc considérés les classes <code>Compagnie</code>, <code>SegmentVoyage</code>, <code>Terminal</code>, <code>Vehicule</code>, <code>Section</code> et <code>UniteReservable</code> comme étant abstraites, car elles servent de classes de base dans des hiérarchies de généralisation. Notre choix fait du sens si on se base sur les heuristiques du cours, où les classes mères sont généralement abstraites pour permettre l'extension du système sans modifier la logique.</p>

            <h4>Calcul par paquet</h4>
            <table>
                <thead>
                    <tr>
                        <th>Package</th>
                        <th>C<sub>a</sub></th>
                        <th>C<sub>e</sub></th>
                        <th>I</th>
                        <th>N<sub>a</sub></th>
                        <th>N<sub>c</sub></th>
                        <th>A</th>
                        <th>D = |A+I-1|</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Voyages</td>
                        <td>1</td>
                        <td>1</td>
                        <td>0.5</td>
                        <td>3</td>
                        <td>12</td>
                        <td>0.25</td>
                        <td>0.25</td>
                    </tr>
                    <tr>
                        <td>Reservations</td>
                        <td>0</td>
                        <td>3</td>
                        <td>1</td>
                        <td>0</td>
                        <td>2</td>
                        <td>0</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>Paiements</td>
                        <td>1</td>
                        <td>0</td>
                        <td>0</td>
                        <td>0</td>
                        <td>3</td>
                        <td>0</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>Vehicules</td>
                        <td>2</td>
                        <td>0</td>
                        <td>0</td>
                        <td>3</td>
                        <td>11</td>
                        <td>0.272727</td>
                        <td>0.727273</td>
                    </tr>
                </tbody>
            </table>

            <h4>Graphe I/A</h4>
            <div class="figure">
                <img src="Img/graphe_ia_new.png" alt="Graphe IA du système de réservation de voyage" style="max-width: 100%; height: auto;">
                <p class="caption">Figure 4 : Graphe Instabilité/Abstraction</p>
            </div>

            <h4>Analyse de l'allure du graphe</h4>
            <p>En analysant notre graphe IA, on peut observer que le paquet <strong>Reservations</strong> se situe au point (1, 0) ce qui correspond à un paquet très instable et complètement concret. On peut dire que c'est logique, car il dépend de plusieurs autres modules pour fonctionner.</p>
            <p>Le paquet <strong>Voyages</strong> a une instabilité moyenne avec un faible niveau d'abstraction, ce qui nous montre qu'il dépend partiellement des autres paquets tout en restant majoritairement concret.</p>
            <p>Les paquets <strong>Paiements</strong> et <strong>Vehicules</strong> sont quant à eux très stables, car ils ont peu ou pas de dépendances sortantes. Par contre, leur niveau d'abstraction est faible, surtout pour Paiements qui se retrouve au point (0, 0). Cela indique que ces paquets sont plus rigides et pourraient être plus difficiles à modifier ou à faire évoluer.</p>
            <p><strong>Conclusion :</strong> Globalement, le design respecte partiellement le Stable Abstractions Principle, mais certains paquets stables ne sont pas assez abstraits, ce qui peut créer des limitations en termes de flexibilité et d'évolution du système.</p>
        </div>

"""
    lines[start_idx:end_idx] = [new_content]
    with open("/Users/mostafa/Downloads/Rapport/index.html", "w") as f:
        f.writelines(lines)
    print("Successfully replaced.")
else:
    print("Could not find start or end index.")

