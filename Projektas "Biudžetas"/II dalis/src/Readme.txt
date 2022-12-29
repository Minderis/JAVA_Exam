Pagal užduoties sąlygas:
1. Masyvai pakeist į ArrayList<PajamuIrasas> ir ArrayList<IslaiduIrasas>.
2. Klasėje Biudžetas pridėtas metodas balansas(), kuris grąžina pajamų ir išlaidų skirtumą (meniu punktas [5]).
3. Vartotojui paprašius yra galimybė atspausdinti visas pajamas ir visas išlaidas (meniu punktai [6] ir [7]).
   Reikalavimas [Spausdinant formatavimui naudoti String.format] pakeistas į printf metodą pagal InteliJ rekomendaciją:
   Iš: System.out.println(String.format(Messages.STRING_FORMAT_FOR_INPUT.message, pi.getId(), pi.getSuma(), pi.getData(), pi.getKategorija(), pi.isPozymisArIBanka(), pi.getPapildomaInfo()));
   Į:  System.out.printf((Messages.STRING_FORMAT_FOR_INPUT.message) + "%n", pi.getId(), pi.getSuma(), pi.getData(), pi.getKategorija(), pi.isPozymisArIBanka(), pi.getPapildomaInfo());
4. Leidžiama vartotojui pasirinkti ir pašalinti bet kurį sąrašuose esantį pajamų ir išlaidų įrašą, pagal pasirinktą Id (meniu punktai [8] ir [9]).
5. Papildomai padaryta: vartotojui paprašius yra galimybė atspausdinti visus pajamų ir išlaidų įrašus (meniu punktai [6] ir [7]).
   Pajamų ir Išlaidų sumų atvaizdavimui naudojamas skirtingas formatavimas.
6. Į InteliJ rodomus warnings nebuvo kreipiamas dėmesys, kadangi siūlomi pataisymai (final reikšmių nustatymas),
   kitose užduoties dalyse privalėtų būti gražinti į ęsamas reikšmes, t.y. turės būti galimybė keisti laukų reikšmes.