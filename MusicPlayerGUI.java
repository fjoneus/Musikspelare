

package Proj6;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Oscar Johansson, Andreas Ellingsen, Filip Joneus, Gustav Andersson
 */
public class MusicPlayerGUI extends javax.swing.JFrame {

	/**
	 * Creates new form MusicPlayerGUI
	 */
	public MusicPlayerGUI() {
		super("TuneIFY");
		playThisSong = "Enter Song or Artist";
		hash = ReadSongsFromFile.initHashTable();
		randomarray = ReadSongsFromFile.getRandomArray();
		player = new MusicPlayer();
		initComponents();
	}

	 /**
          * Initializing the GUI
          */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		play = new javax.swing.JButton();
		searchBar = new javax.swing.JTextField();
		searchButton = new javax.swing.JButton();
		currentSong = new javax.swing.JLabel();
		pause = new javax.swing.JButton();
		resultspane = new javax.swing.JScrollPane();
		results = new javax.swing.JList<>();
		stop = new javax.swing.JButton();
		showQueueButton = new javax.swing.JToggleButton();
		next = new javax.swing.JButton();
		timeline = new javax.swing.JSlider();
		songLength = new javax.swing.JTextField();
		queuepane = new javax.swing.JScrollPane();
		queue = new javax.swing.JList<>();
		elapsedTime = new javax.swing.JTextField();
		queuetext = new javax.swing.JTextField();
		background = new javax.swing.JLabel();
		random = new javax.swing.JButton();
		volumeslide = new javax.swing.JSlider();
		volumetext = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		play.setText("PLAY");
		play.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				playActionPerformed(evt);
			}
		});
		getContentPane().add(play);
		play.setBounds(228, 406, 70, 35);

		random.setText("PLAY RANDOM");
		random.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				randomActionPerformed(evt);
			}
		});
		getContentPane().add(random);
		random.setBounds(20, 406, 120, 35);

		searchBar.setBackground(new java.awt.Color(0, 0, 0, 64));
		searchBar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		searchBar.setForeground(new java.awt.Color(240, 240, 240));
		searchBar.setText("Enter Song or Artist");
		searchBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		searchBar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				searchBarMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				searchBarMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				searchBarMouseExited(evt);
			}
		});

		searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				searchBarKeyPressed(evt);
			}
		});

		getContentPane().add(searchBar);
		searchBar.setBounds(20, 20, 210, 30);

		searchButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		searchButton.setText("Search");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchButtonActionPerformed(evt);
			}
		});
		getContentPane().add(searchButton);
		searchButton.setBounds(230, 20, 63, 30);

		currentSong.setBackground(new java.awt.Color(204, 255, 255));
		currentSong.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
		currentSong.setForeground(java.awt.Color.white);
		currentSong.setText("No Song Playing");
		getContentPane().add(currentSong);
		currentSong.setBounds(180, 310, 350, 50);
		
		volumetext.setText("Volume");
		volumetext.setForeground(java.awt.Color.white);
		volumetext.setBounds(20, 375, 50, 10);
		getContentPane().add(volumetext);
		

		pause.setText("PAUSE");
		pause.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pauseActionPerformed(evt);
			}
		});
		getContentPane().add(pause);
		pause.setBounds(308, 406, 70, 35);

		results.setBackground(new java.awt.Color(0, 0, 0, 64));
		results.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		results.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		results.setForeground(new java.awt.Color(240, 240, 240));
		results.setModel(new MyModel(artistresults));
		results.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		results.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		results.setDoubleBuffered(true);
		results.setOpaque(false);
		results.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				resultsMouseClicked(evt);
			}
		});
		resultspane.setViewportView(results);

		getContentPane().add(resultspane);
		resultspane.setBounds(20, 60, 270, 190);

		stop.setText("STOP");
		stop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopActionPerformed(evt);
			}
		});
		getContentPane().add(stop);
		stop.setBounds(150, 406, 70, 35);

		showQueueButton.setText("Show Queue");
		showQueueButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showQueueButtonActionPerformed(evt);
			}
		});
		getContentPane().add(showQueueButton);
		showQueueButton.setBounds(465, 412, 130, 23);

		next.setText("NEXT");
		next.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextActionPerformed(evt);
			}
		});
		getContentPane().add(next);
		next.setBounds(387, 406, 70, 35);

		timeline.setMaximum(100);
		timeline.setValue(0);
		timeline.setAutoscrolls(true);
		timeline.addChangeListener(new javax.swing.event.ChangeListener() {

			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				timelineStateChanged(evt);
			}
		});
		getContentPane().add(timeline);
		timeline.setBounds(210, 370, 200, 26);
		
		volumeslide.setMaximum(100);
		volumeslide.setMinimum(0);
		volumeslide.setValue(20);
		volumeslide.setAutoscrolls(true);
		volumeslide.addChangeListener(new javax.swing.event.ChangeListener() {

			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				volumeslideStateChanged(evt);
			}
		});
		volumeslide.setOrientation(SwingConstants.VERTICAL);
		volumeslide.setBounds(20, 270, 40, 100);
		getContentPane().add(volumeslide);

		songLength.setBackground(new java.awt.Color(0, 0, 0, 64));
		songLength.setForeground(new java.awt.Color(240, 240, 240));
		songLength.setText("0:00");
		songLength.setBorder(null);

		getContentPane().add(songLength);
		songLength.setBounds(410, 370, 40, 30);

		queue.setBackground(new java.awt.Color(0, 0, 0, 64));
		queue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		queue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		queue.setForeground(new java.awt.Color(240, 240, 240));
		queue.setModel(new MyModel(queueresults));
		queue.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		queue.setDoubleBuffered(true);
		queue.setOpaque(false);
		queuepane.setViewportView(queue);

		getContentPane().add(queuepane);
		queuepane.setBounds(320, 60, 260, 190);
		queuepane.setVisible(false);

		elapsedTime.setBackground(new java.awt.Color(0, 0, 0, 64));
		elapsedTime.setForeground(new java.awt.Color(240, 240, 240));
		elapsedTime.setText("0");
		elapsedTime.setBorder(null);
		getContentPane().add(elapsedTime);
		elapsedTime.setBounds(170, 370, 40, 30);

		queuetext.setBackground(new java.awt.Color(0, 0, 0, 64));
		queuetext.setForeground(new java.awt.Color(240, 240, 240));
		queuetext.setText("Queue:");
		queuetext.setOpaque(false);
		getContentPane().add(queuetext);
		queuetext.setBounds(410, 30, 70, 30);
		queuetext.setVisible(false);

		background.setIcon(new javax.swing.ImageIcon("imagex.jpg")); // NOI18N
		background.setText("Background");
		getContentPane().add(background);
		background.setBounds(0, 0, 600, 450);
		background.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				backgroundMouseClicked(evt);
			}

		});

		setSize(616, 490);
	}// </editor-fold>

	private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {
		playThisSong = "Enter Song or Artist";

	}
	/**
     * Listener for the "Enter button", displays either the song or the artist's songs searched for
     * if no song/artist is found a catch prints "could not find..." as results.
     */
	private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			playThisSong = searchBar.getText();
			try {
			ArrayList<ItemSong> list = hash.find(playThisSong);
			artistresults = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				artistresults[i] = ((ItemSong) list.get(i)).getSongTitle();
			}
			results.setModel(new MyModel(artistresults));
			playThisSong = "Enter Song or Artist";
			searchBar.setText(playThisSong);
			} catch (Exception e) {
				artistresults = new String[1];
				artistresults[0] = "Couldnt Find Song/Artist";
				results.setModel(new MyModel(artistresults));
			}
		}
	}
    /**
     * Listener for the stop button, simply calls for musicplayers stop() method.
     * @param evt
     */
	private void stopActionPerformed(java.awt.event.ActionEvent evt) {
		player.stop();
		play.setText("PLAY");
	}
    /**
     * This listener waits for inputs in the JScrollPane, if we double-click an object in the resultpane
     * the corresponding song is added first in queue and played, however if we right-click a focused object it's
     * added last in the queue.
     * @param evt
     */
	private void resultsMouseClicked(java.awt.event.MouseEvent evt) {
		int x = results.getSelectedIndex();
		ArrayList<ItemSong> templist = hash.find(artistresults[x]);
		if (evt.getButton() == evt.BUTTON1 && evt.getClickCount() == 2) {
			player.addSongFirstInQueue(((ItemSong) templist.get(0)));
			next();

		} else if (evt.getButton() == evt.BUTTON3) {

			player.addSongToQueue((ItemSong) templist.get(0));
			ArrayDeque<ItemSong> qu = player.getQueue();
			queueresults = new String[qu.size()];
			java.util.Iterator<ItemSong> itr = qu.iterator();
			int cc = 0;
			while (itr.hasNext()) {
				queueresults[cc++] = itr.next().toString();
			}
			queue.setModel(new MyModel(queueresults));
		}
	}
    /**
     * Listener for the Next button, simply calls for the method next()
     * @param evt
     */
	private void nextActionPerformed(java.awt.event.ActionEvent evt) {
		play.setText("PLAY");
		next();
	}
    /**
     * Listener for the "random button" which uses Math.random() to get the String that represent a random song
     * then adds it first in queue and calls the method next() to play it.
     * @param evt
     */
	private void randomActionPerformed(java.awt.event.ActionEvent evt) {
		int x = (int) (Math.random() * (randomarray.length));
		ArrayList<ItemSong> templist = hash.find(randomarray[x]);
		player.addSongFirstInQueue(((ItemSong) templist.get(0)));
		play.setText("PLAY");
		next();

	}
	/**
     * Listener for the search button, displays either the song or the artist's songs searched for
     * if no song/artist is found a catch prints "could not find..." as results.
     */
	private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
		playThisSong = searchBar.getText();
		try {
		ArrayList<ItemSong> list = hash.find(playThisSong);
		artistresults = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			artistresults[i] = ((ItemSong) list.get(i)).getSongTitle();
		}
		results.setModel(new MyModel(artistresults));
		playThisSong = "Enter Song or Artist";
		searchBar.setText(playThisSong);
		} catch (Exception e) {
			artistresults = new String[1];
			artistresults[0] = "Couldnt Find Song/Artist";
			results.setModel(new MyModel(artistresults));
		}

	}
	/**
     * Listener for the toggle button "show queue" 
     * depending on the state it shows respectively hides the JScrollBar showing songs in queue
     */
	private void showQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (showQueueButton.isSelected()) {
			showQueueButton.setText("Hide Queue");
			queuepane.setVisible(true);
			queuetext.setVisible(true);

		} else if (!showQueueButton.isSelected()) {
			showQueueButton.setText("Show Queue");
			queuepane.setVisible(false);
			queuetext.setVisible(false);
		}
	}

	private void searchBarMouseClicked(java.awt.event.MouseEvent evt) {
		playThisSong = "";
		searchBar.setText(playThisSong);
		

	}

	private void searchBarMouseExited(java.awt.event.MouseEvent evt) {
		searchBar.setText(playThisSong);
	}

	private void searchBarMouseEntered(java.awt.event.MouseEvent evt) {
		searchBar.setText(playThisSong);
	}
	/**
     * Listener for play button, Calls Musicplayer's method play()
     */
	private void playActionPerformed(java.awt.event.ActionEvent evt) {
		playThisSong = "Enter Song or Artist";
		searchBar.setText(playThisSong);
		player.play();
		play.setText("PLAY");

	}
    /**
     * Listener for pause button, calls for Musicplayer's method pause()
     */
	private void pauseActionPerformed(java.awt.event.ActionEvent evt) {
		player.pause();
		play.setText("RESUME");
	}
    /**
     * Listener for the timeline, if the value is changed calls for Musicplayers method setTime()
     * @param evt
     */
	private void timelineStateChanged(javax.swing.event.ChangeEvent evt) {
		if (ignoreEvents) {
			return;
		}
		int x = timeline.getValue();
		player.setTime(x);
		elapsedTime.setText(player.timeToString(player.getCurrentPos()));
	}
    
	private void volumeslideStateChanged(javax.swing.event.ChangeEvent evt) {
		player.setVolume(volumeslide.getValue());
	}
	/**
	 * This method plays the next song in queue in "MusicPlayer", also updates
	 * various GUI variables. next() also calls itself recursively if the current
	 * song has reached it's end. next() is called from various listeners the GUI
	 * The timer created in this method is used to continually update the "progress
	 * bar" to the current position of the song duration.
	 */
	private void next() {
		Timer progressTimer = new Timer(500, e -> {
			ignoreEvents = true;
			timeline.setValue(player.getCurrentPos());
			elapsedTime.setText(player.timeToString(player.getCurrentPos()));
			if (player.getCurrentPos() == player.getSongLength()) {
				next();
			}
			SwingUtilities.invokeLater(() -> ignoreEvents = false);

		});
		progressTimer.start();
		if(player.isActive())
			player.terminate();
		
		player.nextSong();
		play.setText("PLAY");
		currentSong.setText(player.getCurrentSong().toString());
		songLength.setText(player.timeToString(player.getSongLength()));
		timeline.setMaximum(player.getSongLength());
		timeline.setValue(0);
		ArrayDeque<ItemSong> qu = player.getQueue();
		queueresults = new String[qu.size()];
		java.util.Iterator<ItemSong> itr = qu.iterator();
		int cc = 0;
		while (itr.hasNext()) {
			queueresults[cc++] = itr.next().toString();
		}
		queue.setModel(new MyModel(queueresults));
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MusicPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MusicPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MusicPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MusicPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MusicPlayerGUI().setVisible(true);
			}
		});
	}

	private javax.swing.JLabel background;
	private javax.swing.JLabel currentSong;
	private javax.swing.JTextField elapsedTime;
	private javax.swing.JButton next;
	private javax.swing.JButton pause;
	private javax.swing.JButton play;
	private javax.swing.JButton random;
	private javax.swing.JList<String> queue;
	private javax.swing.JScrollPane queuepane;
	private javax.swing.JTextField queuetext;
	private javax.swing.JList<String> results;
	private javax.swing.JScrollPane resultspane;
	private javax.swing.JTextField searchBar;
	private javax.swing.JButton searchButton;
	private javax.swing.JToggleButton showQueueButton;
	private javax.swing.JTextField songLength;
	private javax.swing.JButton stop;
	private javax.swing.JSlider timeline;
	private javax.swing.JSlider volumeslide;
	private javax.swing.JLabel volumetext;
	private String[] randomarray;
	private boolean ignoreEvents;
	private String playThisSong;
	private String[] artistresults = { "No Results" };
	private String[] queueresults = { "No Songs in Queue" };
	private static HashTable hash;
	private MusicPlayer player;
}

