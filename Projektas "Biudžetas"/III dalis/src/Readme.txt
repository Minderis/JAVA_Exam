Pagal užduoties sąlygas:
1. Iš dviejų sąrašų ArrayList<PajamuIrasas> ir ArrayList<IslaiduIrasas> paliktas tik viens sąrašas ArrayList<Irasas>.
2. Klasė Irasas turi bendras savybes, tinkančias ir pajamoms, ir išlaidoms: id, suma, atsiskaitymoBudasBankas, papildomaInfo, recordType.
3. Klasė PajamuIrasas paveldi klasę Irasas ir turėti tik su pajamomis susijusius laukus: pajamuKategorija, pajamuTipas, data.
4. Klasė IslaiduIrasas paveldi klasę Irasas ir turėti tik su išlaidomis susijusius laukus: islaiduKategorija, islaiduTipas, dataSuLaiku.
5. Id – yra unikalus identifikacinis numeris, kurį turi kiekvienas įrašas. Jo negalima modifikuoti, jis yra final. Klasė neturi setId metodo.
6. Klasėje Biudzetas yra bendras metodas įrašo pridėjimui: private void pridetiIrasa(Irasas irasas).
7. Klasėje Biudzetas yra atskiri metodai pajamų ir išlaidų įrašų gavimui: private ArrayList<PajamuIrasas> gautiPajamuIrasus() ir private ArrayList<IslaiduIrasas> gautiIslaiduIrasus().
   Jie grąžina PajamuIrasas arba IslaiduIrasas sąrašą.
8. PajamuIrasas ir IslaiduIrasas turi užkoltus toString() metodus, kurie panaudojami spausdinant įrašų informaciją metoduose:
   public void atspausdintiPajamuIrasus() ir public void atspausdintiIslaiduIrasus().
9. Yra užklotas equals() metodas, kuris tikrina ar įrašų ID yra lygūs. Tai realizuota Irasas klasėjė, o tikrinimas atliekamas Biudzetas klaseje,
   private void atnaujintiIrasa(Irasas irasas) metode.
10. Yra galimybė redaguoti pasirinktą įrašą pagal jo id (meniu punktas [2]), iš eilės rodant nustatytas įrašo reikšmes, bei siūlant jas pakeisti.
11. Papildomai padaryta: sukurtą įrašą galima redaguoti 2 būdais: 1 - naujo įrašo sukūrimas ir pakeitimas saraše pagal id;
    2 - dalinis įrašo keitimas, nustatant naujas įrašo reikšmes su set metodais.